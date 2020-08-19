package com.simulator.vehicles;

import com.simulator.*;
import com.weather.Coordinates;
import java.util.*;

public class Helicopter extends Aircraft implements Flyable{
	
	private WeatherTower weatherTower;

	Helicopter (String name, Coordinates coordinates){
		super(name, coordinates);

	}

	public String test(){
		return ("Helicopter");
	}

	public void updateConditions(){
		String weather = this.weatherTower.getWeather(this.coordinates);
		// System.out.println(weather);
		if (weather.equals("Sun")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude()+10,
				coordinates.getLatitude(),
				coordinates.getHeight()+2
			);
			Simulator.OutputFile = Simulator.OutputFile + "Helicopter#"+this.name+"("+this.id+"): Time to fly low and annoy people watching TV.\n";
			// System.out.print("Helicopter#"+this.name+"("+this.id+"): OMG a message apppeared\n");
		}
		if (weather.equals("Rain")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude()+5,
				coordinates.getLatitude(),
				coordinates.getHeight()
			);
			Simulator.OutputFile = Simulator.OutputFile + "Helicopter#"+this.name+"("+this.id+"): Close the side doors the water everywhere!\n";
			// System.out.print("Helicopter#"+this.name+"("+this.id+"): OMG a message apppeared\n");
		}
		if (weather.equals("Fog")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude()+1,
				coordinates.getLatitude(),
				coordinates.getHeight()
			);
			Simulator.OutputFile = Simulator.OutputFile + "Helicopter#"+this.name+"("+this.id+"): I'm legally blind!\n";
			// System.out.print("Helicopter#"+this.name+"("+this.id+"): OMG a message apppeared\n");
		}
		if (weather.equals("Snow")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude(),
				coordinates.getHeight()-12
			);
			Simulator.OutputFile = Simulator.OutputFile + "Helicopter#"+this.name+"("+this.id+"): Maybe we should land i've seen what happens to Heli's in Godzilla\n";
			// System.out.print("Helicopter#"+this.name+"("+this.id+"): OMG a message apppeared\n");
		}
		if (this.coordinates.getHeight() > 100)
		this.coordinates = new Coordinates(
			coordinates.getLongitude(),
			coordinates.getLatitude(),
			100
		);
		if (this.coordinates.getHeight() < 0){
			System.out.print("Landing "+this.name);
			weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weatherTower){
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}

}
