package com.simulator;

import java.util.*;
import com.simulator.vehicles.Flyable;

public abstract class Tower {
	
	private List<Flyable> observers = new ArrayList<>(); 

	public void register(Flyable flyable){
		observers.add(flyable);
	}

	public void unregister(Flyable flyable){
		observers.remove(flyable);
	}

	protected void conditionsChanged(){
		for(Flyable flyable : observers){
			System.out.println("Condiditons Changed");
			flyable.updateConditions();
		}
	}

}
