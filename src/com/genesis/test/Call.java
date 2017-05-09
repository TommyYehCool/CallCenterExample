package com.genesis.test;

public class Call {
	/**
	 * The id of the call
	 */
	private String id;
	/**
	 * minimal level of employee who can handle this call
	 */
	private int level = 0;
	
	public Call(int id, EmployLevel minimalPosCanHandler) {
		this.id = "Call_" + id + "_For_" + minimalPosCanHandler;
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

	/**
	 * Notify caller to wait
	 */
	public void notifyCallerToWait() {
		System.out.println("#### [" + this.id + "] Please wait for free employee ####");
	}

	/**
	 * Disconnect the call
	 * 
	 * @param empName The name of employee who handled the call
	 */
	public void disconnect(String empName) {
		System.out.println("===> [" + empName + "] thanks for your calling [" + this.id + "]");
	}

}
