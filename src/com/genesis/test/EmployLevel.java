package com.genesis.test;

public enum EmployLevel {
	Fresher(0),
	
	TechnicalLead(1),
	
	ProductManager(2);
	
	private int level;
	
	private EmployLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return this.level;
	}
}	
