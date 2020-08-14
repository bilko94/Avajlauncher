package com.Simulator.vehicles;

import com.Simulator.WeatherTower;

public interface Flyable {
	
	public void updateConditions();
	public void registerTower(WeatherTower weatherTower);

}
