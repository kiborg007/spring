package com.roman.service;

import com.roman.model.Coordinates;

public interface CoordinatesService {

	public void addCoordinate(Coordinates c);
	public Coordinates getCoordinateById(int id);
	public Coordinates getCoordinateByPersonId(int id);
}
