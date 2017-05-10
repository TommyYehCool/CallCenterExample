package com.genesis.test;

/**
 * Define all of the employees and his/her level 
 */
public enum EmployeeLevel {
	Fresher(0),
	
	TechnicalLead(1),
	
	ProductManager(2);
	
	private int level;
	
	private EmployeeLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return this.level;
	}
}	
