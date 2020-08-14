package com.Simulator;

import com.Simulator.vehicles.Flyable;

public abstract class Tower {
	
	private Flyable observers; 

	Tower(){

	}

	public void register(Flyable flyable){
		this.observers = flyable;
		//do some shit
	}

	public void unregister(Flyable flyable){
		this.observers = null;
		//do some shit
	}

	protected void conditionsChanged(){
		//do some shit
	}

}
