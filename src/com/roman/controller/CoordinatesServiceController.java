package com.roman.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.roman.engine.Engine;
import com.roman.model.Coordinates;
import com.roman.model.Person;
import com.roman.service.CoordinatesService;
import com.roman.service.PersonService;

@RestController
@RequestMapping("/rest/service")
public class CoordinatesServiceController {

	private static final Logger logger = Logger.getLogger(CoordinatesServiceController.class);
	private Engine engine ;
	private CoordinatesService coordinatesService ;
	
	@Autowired(required=true)
	@Qualifier(value="engine")
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	@Autowired(required=true)
	@Qualifier(value="coordinatesService")
	public void setCoordinatesService(CoordinatesService ps){
		this.coordinatesService = ps;
	}
	
	@RequestMapping(value = "/newCoordinate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)  
	public void addCoordinate(@RequestBody Coordinates coord){
		try{
			engine.put(coord);
			logger.info("New Coordinate was putted in");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	// Tmp test method
	@RequestMapping(value = "/getCoord/{id}", method = RequestMethod.GET, produces = "application/json") 
	public @ResponseBody Coordinates getCoordinate(@PathVariable("id") int id){
		Coordinates coord = coordinatesService.getCoordinateById(id);
		//Coordinates coord = engine.get(id);
		logger.info("======= Coordinate - "+coord+" =======");
		return coord ;
	}
	

	@RequestMapping(value = "/getCoordByPersonId/{id}", method = RequestMethod.GET, produces = "application/json") 
	public @ResponseBody Coordinates getCoordinateByPersonId(@PathVariable("id") int id){
		//Coordinates coord = coordinatesService.getCoordinateById(id);
		Coordinates coord = engine.get(id);
		logger.info("======= Coordinate - "+coord+" =======");
		return coord ;
	}

}
