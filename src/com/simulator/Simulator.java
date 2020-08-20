package com.simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


import com.simulator.vehicles.AircraftFactory;
import com.simulator.vehicles.Flyable;

public class Simulator {
	private static WeatherTower weatherTower;
	// private static List<Flyable> flyables = new ArrayList<Flyable>();
	public static String OutputFile = "";

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
				Simulator.OutputFile = Simulator.OutputFile + simulations+"\n";
				while ((line = reader.readLine()) != null) {
					Simulator.OutputFile = Simulator.OutputFile + "Tower says: "+ line.split(" ")[0] +"#"+line.split(" ")[1];
					AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
						Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
						Integer.parseInt(line.split(" ")[4])).registerTower(weatherTower);
					Simulator.OutputFile = Simulator.OutputFile + " registered to weather tower.\n";
				}

				File myObj = new File("Simulation.txt");
				myObj.createNewFile();

				for (int i = 1; i <= simulations; i++) {
					// System.out.println("Changing weather");
					weatherTower.changeWeather();
				}

				FileWriter myWriter = new FileWriter("Simulation.txt");
      			myWriter.write(Simulator.OutputFile);
				myWriter.close();
				// System.out.println(Simulator.OutputFile);

			}
			reader.close();
		}
		catch (FileNotFoundException e) {
            System.out.println("File not found exception " + args[0]);
        }
        catch (IOException e) {
            System.out.println("Error reading file: " + args[0]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("File error");
        }
		catch (NumberFormatException e) {
			System.out.println("Invalid number format in scenario file");
		}
		catch (NullPointerException e) {
			System.out.println("Null point found in file");
		}
        catch (Exception e) {
            System.out.println("Invalid input inside scenario file");
			e.printStackTrace();
        }
	}
	
}
