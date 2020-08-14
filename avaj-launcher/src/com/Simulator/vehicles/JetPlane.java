package com.Simulator.vehicles;

import com.Simulator.WeatherTower;
import com.weather.Coordinates;

public class JetPlane extends Aircraft implements Flyable{
	
	private WeatherTower WeatherTower;

	JetPlane (String name, Coordinates coordinates){

		super(name, coordinates);

	}

	public void updateConditions(){

	}

	public void registerTower(WeatherTower weatherTower){
		
	}

}