package com.simulator.vehicles;

import com.simulator.WeatherTower;
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
		System.out.println(weather);
		if (weather.equals("Sun")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude()+2,
				coordinates.getLatitude(),
				coordinates.getHeight()+4
			);
			System.out.print("Baloon#"+this.name+"("+this.id+"): OMG a message apppeared\n");
		}
		if (weather.equals("Rain")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude(),
				coordinates.getHeight()-5
			);
			System.out.print("Baloon#"+this.name+"("+this.id+"): OMG a message apppeared\n");
		}
		if (weather.equals("Fog")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude(),
				coordinates.getHeight()-3
			);
			System.out.print("Baloon#"+this.name+"("+this.id+"): OMG a message apppeared\n");
		}
		if (weather.equals("Snow")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude(),
				coordinates.getHeight()-15
			);
			System.out.print("Baloon#"+this.name+"("+this.id+"): OMG a message apppeared\n");
		}
		// if (this.coordinates.getHeight() < 0){
		// 	System.out.print("Landing "+this.name);
		// 	weatherTower.unregister(this);
		// }
	}

	public void registerTower(WeatherTower weatherTower){
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}
}
