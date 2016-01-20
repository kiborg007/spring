package com.roman.engine;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.roman.model.Coordinates;
import com.roman.service.CoordinatesService;


public class Engine {

	private Logger logger = Logger.getLogger(Engine.class);
	private final HashMap<Integer, Coordinates> hash = new HashMap<Integer, Coordinates>(); // Integer - personID; 
	private CoordinatesService coordinatesService ;

	Engine() {
		
	}

	public synchronized void put(Coordinates coord) {

		HashMap<Integer, Coordinates> map = getHash();
		if (!map.containsKey(coord.getPerson().getPersonID())) { // если такого id нет в хеше, то добавляем координату 
			map.put(coord.getPerson().getPersonID(), coord);
		} else { // если такоя координата уже есть в хеше, то просто добавляем в БД
			coordinatesService.addCoordinate(map.get(coord.getPerson().getPersonID())); // заменить на : coordinatesService.addCoordinate(coord);
			map.replace(coord.getPerson().getPersonID(), coord);
		}
	}
	
	public Coordinates get(Integer id){
		if (hash.containsKey(id)){
			return hash.get(id);
		}else{ // вот тут не верно ! нельзя так выбрать только одну координату. потому-что у пользователя много координат.
			Coordinates coord = coordinatesService.getCoordinateByPersonId(id); // метод, который будет брать координату по id пользователя !!!
			hash.put(id, coord);
			return coord ;
		}
	}
	

	public  HashMap<Integer, Coordinates> getHash() {
		return this.hash;
	}

	public void setCoordinatesService(CoordinatesService coordinatesService) {
		this.coordinatesService = coordinatesService;
	}

	

}
