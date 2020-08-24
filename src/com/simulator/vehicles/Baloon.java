package com.simulator.vehicles;

import com.simulator.*;
import com.weather.Coordinates;

public class Baloon extends Aircraft implements Flyable{
	
	private WeatherTower weatherTower;

	Baloon (String name, Coordinates coordinates){

		super(name, coordinates);

	}

	public String test(){
		return ("Baloon");
	}

	public void updateConditions(){
		String weather = this.weatherTower.getWeather(this.coordinates);
		// System.out.println(weather);
		if (weather.equals("Sun")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude()+2,
				coordinates.getLatitude(),
				coordinates.getHeight()+4
			);
			Simulator.OutputFile = Simulator.OutputFile + "Baloon#"+this.name+"("+this.id+"): Such a nice day, too bad we can't spell Balloon properly.\n";
			// System.out.print("Baloon#"+this.name+"("+this.id+"): OMG a message apppeared\n");
		}
		else if (weather.equals("Rain")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude(),
				coordinates.getHeight()-5
			);
			Simulator.OutputFile = Simulator.OutputFile + "Baloon#"+this.name+"("+this.id+"): I guess we deserve this rain considering we can't spell Balloon.\n";
			// System.out.print("Baloon#"+this.name+"("+this.id+"): OMG a message apppeared\n");
		}
		else if (weather.equals("Fog")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude(),
				coordinates.getHeight()-3
			);
			Simulator.OutputFile = Simulator.OutputFile + "Baloon#"+this.name+"("+this.id+"): Surprised we can fly in this weather.\n";
			// System.out.print("Baloon#"+this.name+"("+this.id+"): OMG a message apppeared\n");
		}
		else if (weather.equals("Snow")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude(),
				coordinates.getHeight()-15
			);
			Simulator.OutputFile = Simulator.OutputFile + "Baloon#"+this.name+"("+this.id+"): My mama said if you can't spell Balloon then santa gonna send you coal.\n";
			// System.out.print("Baloon#"+this.name+"("+this.id+"): OMG a message apppeared\n");
		}
		if (this.coordinates.getHeight() < 0){
			Simulator.OutputFile = Simulator.OutputFile + "Baloon#"+this.name+"("+this.id+"): Landing. Coordinates: "+coordinates.getLongitude()+":"+coordinates.getLatitude()+"\n";
			Simulator.OutputFile = Simulator.OutputFile + "Tower says: Baloon#"+this.name+"("+this.id+") unregistered from weather tower.\n";
			weatherTower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weatherTower){
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}
}
