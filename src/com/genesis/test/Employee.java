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
	
	public int getLevel() {
		return this.level;
	}
	
	public boolean isFree() {
		return this.free;
	}
	
	public void receiveCall(Call call) {
		this.free = false;
		System.out.println(name + " receive " + call.getId());
	}
	
	public void callHandled(Call call) {
		System.out.println(name + " handled " + call.getId());
		call.disconnect(name);
		this.free = true;
		callHandler.getNextCall(this);
	}

	public void cannotHandle(Call call) {
		call.setLevel(level + 1);
        callHandler.dispatchCall(call);
        this.free = true;
        // look if there is a call waiting in queue
        callHandler.getNextCall(this);
	}
	
}
