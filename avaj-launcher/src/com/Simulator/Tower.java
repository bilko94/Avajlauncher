package com.Simulator;

import com.Simulator.vehicles.Flyable;
import java.util.ArrayList;

public abstract class Tower {
	
	private ArrayList<Flyable> observers = new ArrayList<>(); 

	Tower(){

	}

	public void register(Flyable flyable){
		observers.add(flyable);
		//do some shit
	}

	public void unregister(Flyable flyable){
		observers.remove(flyable);
		//do some shit
	}

	protected void conditionsChanged(){
		//do some shit
	}

}
