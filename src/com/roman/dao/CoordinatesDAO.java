package com.roman.dao;

import com.roman.model.Coordinates;

public interface CoordinatesDAO {

	public void addCoordinate(Coordinates c);
	public Coordinates getCoordinateById(int id);
	public Coordinates getCoordinateByPersonId(int id);
}
