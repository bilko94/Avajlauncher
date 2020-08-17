package com.simulator.vehicles;

import com.simulator.WeatherTower;

public interface Flyable {
	
	public void updateConditions();
	public void registerTower(WeatherTower weatherTower);
	public String test();

}
