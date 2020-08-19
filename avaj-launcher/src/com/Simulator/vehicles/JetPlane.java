package com.simulator.vehicles;

import com.simulator.*;
import com.weather.Coordinates;
import java.io.*;

public class JetPlane extends Aircraft implements Flyable{
	
	private WeatherTower weatherTower;

	JetPlane (String name, Coordinates coordinates){
		super(name, coordinates);
	}

	public String test(){
		return ("Jetplane");
	}

	public void updateConditions(){
		String weather = this.weatherTower.getWeather(this.coordinates);
		// System.out.println(weather);
		if (weather.equals("Sun")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude()+10,
				coordinates.getHeight()+2
			);
			Simulator.OutputFile = Simulator.OutputFile + "JetPlane#"+this.name+"("+this.id+"): All this sun is making this cockpit really hot.\n";
			// System.out.print("JetPlane#"+this.name+"("+this.id+"): OMG a message apppeared\n");
		}
		if (weather.equals("Rain")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude()+5,
				coordinates.getHeight()
			);
			Simulator.OutputFile = Simulator.OutputFile + "JetPlane#"+this.name+"("+this.id+"): Why don't jets have window wipers?\n";
			// System.out.print("JetPlane#"+this.name+"("+this.id+"): OMG a message apppeared\n");
		}
		if (weather.equals("Fog")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude()+1,
				coordinates.getHeight()
			);
			Simulator.OutputFile = Simulator.OutputFile + "JetPlane#"+this.name+"("+this.id+"): Alpha two whats your coordinates i can't see shit!\n";
			// System.out.print("JetPlane#"+this.name+"("+this.id+"): OMG a message apppeared\n");
		}
		if (weather.equals("Snow")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude(),
				coordinates.getHeight()-7
			);
			Simulator.OutputFile = Simulator.OutputFile + "JetPlane#"+this.name+"("+this.id+"): Nice cold day for a sick Jetstream.\n";
			// System.out.print("JetPlane#"+this.name+"("+this.id+"): OMG a message apppeared\n");
		}
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