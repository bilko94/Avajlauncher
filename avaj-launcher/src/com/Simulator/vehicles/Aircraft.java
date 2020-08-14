package com.Simulator.vehicles;

import com.weather.Coordinates;

public abstract class Aircraft {
	
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter;

	protected Aircraft(String name, Coordinates coordinates){
		name = this.name;
		coordinates = this.coordinates;
	}

	private long nextId(){
		return Aircraft.idCounter+1;
	}

}