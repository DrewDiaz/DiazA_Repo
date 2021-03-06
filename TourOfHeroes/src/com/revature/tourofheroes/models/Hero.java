package com.revature.tourofheroes.models;

import java.util.Arrays;

import com.revature.tourofheroes.exceptions.InvalidHealthValueException;

//POJO
public class Hero {
	//attributes
	//private makes this safe from modification, encapsulates
	private String name;
	private String[] specialMove;
	private int healthLevel; 
	private boolean isAlive; 
	
	//constructor
	public Hero() {
		
	}
	
	public Hero(String name, String[] specialMove) {
		super();
		//calls parent
		this.name = name;
		this.specialMove = specialMove; 
	}

	public Hero(String name, String[] specialMove, int healthLevel, boolean isAlive) throws InvalidHealthValueException {
		//chaining
		this(name, specialMove);
		
		
				if(healthLevel < 0) {
					throw new InvalidHealthValueException("Health level should not be negative!");
				}
				else {
					this.healthLevel = healthLevel;
				}
		this.isAlive = isAlive;
	}

	@Override
	public String toString() {
		return "Hero [name=" + name + ", specialMove=" + Arrays.toString(specialMove) + ", healthLevel=" + healthLevel
				+ ", isAlive=" + isAlive + "]";
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isAlive ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hero other = (Hero) obj;
		if (isAlive != other.isAlive)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public void setName(String name) {
		//check if the name is numbers
		if(name.isEmpty()) throw new IllegalArgumentException();
		this.name = name;
	}

	public String[] getSpecialMove() {
		return specialMove;
	}

	public void setSpecialMove(String[] specialMove) {
		this.specialMove = specialMove;
	}

	public int getHealthLevel() {
		return healthLevel;
	}

	public void setHealthLevel(int healthLevel) throws Exception {
		if(healthLevel < 0) {
			throw new InvalidHealthValueException("Health level should not be negative!");
		}
		else {
			this.healthLevel = healthLevel;
		}
		
		
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	
}
