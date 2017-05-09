package com.genesis.test;

public class Call {
	private String id;
	private int level = 0; // minimal level of employee who can handle this call
	
	public Call(int id, EmployLevel minimalPosCanHandler) {
		this.id = "Call_" + id;
		this.level = minimalPosCanHandler.getLevel();
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setLevel(int rank) {
		this.level = rank;
	}

	public int getLevel() {
		return this.level;
	}

	public void reply(String message) {
		System.out.println(message);
	}

	public void disconnect(String empName) {
		reply("[" + this.id + "] " + empName + " thanks for your calling");
	}

}
