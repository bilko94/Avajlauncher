package com.Simulator.vehicles;

import com.Simulator.WeatherTower;
import com.weather.Coordinates;

public class Baloon extends Aircraft implements Flyable{
	
	private WeatherTower WeatherTower;

	Baloon (String name, Coordinates coordinates){

		super(name, coordinates);

	}

	public void updateConditions(){

	}

	public void registerTower(WeatherTower weatherTower){
		
	}
}
