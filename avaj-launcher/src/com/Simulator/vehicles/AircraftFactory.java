package com.simulator.vehicles;

import com.weather.Coordinates;
import com.simulator.*;

public abstract class AircraftFactory {

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		// Simulator.OutputFile = Simulator.OutputFile + "created aircraft\n";

		String str = type.toLowerCase();
		if (str.equals("baloon")){
			return new Baloon(name, coordinates);
		} else if (str.equals("helicopter")){
			return new Helicopter(name, coordinates);
		} else if (str.equals("jetplane")){
			return new JetPlane(name, coordinates);
		} else{
			return null;
		}
	}

}
