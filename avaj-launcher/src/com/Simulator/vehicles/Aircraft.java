package com.simulator.vehicles;

import com.weather.Coordinates;
import com.simulator.*;

public abstract class Aircraft {
	
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter;

	protected Aircraft(String name, Coordinates coordinates){
		this.name = name;
		this.coordinates = coordinates;
		this.id = nextId();
		Simulator.OutputFile = Simulator.OutputFile + "(" + this.id + ")";
	}

	private long nextId(){
		Aircraft.idCounter++;
		return Aircraft.idCounter;
	}

}