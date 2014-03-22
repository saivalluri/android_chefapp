package com.example.chef_app;

public class WeaponFactory {
	
	private static int fireSpeed = 0;
	
	//Default constructor
	public WeaponFactory() {
		
	}
	
	public WeaponFactory(int fireSpeed) {
		
		this.fireSpeed = fireSpeed;
	}
	
	private void setSpeed(int speed) {
		
		this.fireSpeed = speed;
		
	}
	
	private int getSpeed() {
		
		return this.fireSpeed;
		
	}
	
}
