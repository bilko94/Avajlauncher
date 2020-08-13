package com.avajlauncher.tower;

import com.avajlauncher.flyable.Flyable;

public abstract class Tower {
	
	private Flyable observers; 

	Tower(){
		Flyable observers = new Flyable();
	}

	public void register(Flyable flyable){
		//do some shit
	}

	public void unregister(Flyable flyable){
		//do some shit
	}

	protected void conditionsChanged(){
		//do some shit
	}

}
