package com.Simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.Simulator.vehicles.AircraftFactory;
import com.Simulator.vehicles.Flyable;

public class Simulator {
	private static WeatherTower weatherTower;
	private static List<Flyable> flyables = new ArrayList<Flyable>();

	public static void main(String[] args) throws InterruptedException {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			String line = reader.readLine();
			if (line != null) {
				weatherTower = new WeatherTower();
				int simulations = Integer.parseInt(line.split(" ")[0]);
				if (simulations < 0) {
					System.out.println("Invalid simulations count");
					System.exit(1);
				}
				while ((line = reader.readLine()) != null) {
					Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
							Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
							Integer.parseInt(line.split(" ")[4]));
					flyables.add(flyable);
				}

				for (Flyable flyable : flyables) {
					flyable.registerTower(weatherTower);
				}

				for (int i = 1; i <= simulations; i++) {
					weatherTower.changeWeather();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
