package com.genesis.test;

public class Employee {
	private String name;
	
	private int level;
	
	private boolean free = true;

	private CallHandler callHandler;
	
	public Employee(String name, EmployLevel employPosition, CallHandler callHandler) {
		this.name = name;
		this.level = employPosition.getLevel();
		this.callHandler = callHandler;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public boolean isFree() {
		return this.free;
	}
	
	public void receiveCall(Call call) {
		this.free = false;
		System.out.println("---> [" + name + "] receive [" + call.getId() + "]");
	}
	
	public void callHandled(Call call) {
		System.out.println("<--- [" + name + "] handled [" + call.getId() + "]");
		call.disconnect(name);
		this.free = true;
		callHandler.getNextCall(this);
	}

}
