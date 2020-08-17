package com.simulator.vehicles;

import com.simulator.WeatherTower;
import com.weather.Coordinates;

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
		System.out.println(weather);
		if (weather.equals("Sun")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude()+10,
				coordinates.getHeight()+2
			);
			System.out.print("JetPlane#"+this.name+"("+this.id+"): OMG a message apppeared\n");
		}
		if (weather.equals("Snow")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude()+5,
				coordinates.getHeight()
			);
			System.out.print("JetPlane#"+this.name+"("+this.id+"): OMG a message apppeared\n");
		}
		if (weather.equals("Fog")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude()+1,
				coordinates.getHeight()
			);
			System.out.print("JetPlane#"+this.name+"("+this.id+"): OMG a message apppeared\n");
		}
		if (weather.equals("Snow")) {
			this.coordinates = new Coordinates(
				coordinates.getLongitude(),
				coordinates.getLatitude(),
				coordinates.getHeight()-7
			);
			System.out.print("JetPlane#"+this.name+"("+this.id+"): OMG a message apppeared\n");
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