package com.simulator;

import com.weather.Coordinates;
import com.weather.WeatherProvider;
import java.util.*;

public class WeatherTower extends Tower{
	
	public String getWeather(Coordinates coordinates){
		String[] weathergen = {"Rain","Fog","Sun","Snow"};
        return weathergen[(int)(Math.random()*((3-0)+1))+0];
	}
	
	void changeWeather(){
		this.conditionsChanged();
	}

}
