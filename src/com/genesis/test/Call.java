package com.genesis.test;

public class Call {
	private String id;
	private int level = 0; // minimal level of employee who can handle this call
	
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

	public void noticeCallToWait() {
		System.out.println("#### [" + this.id + "] Please wait for free employee ####");
	}

	public void disconnect(String empName) {
		System.out.println("===> [" + empName + "] thanks for your calling [" + this.id + "]");
	}

}
