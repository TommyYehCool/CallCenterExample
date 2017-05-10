package com.genesis.test;

/**
 * The object of employee
 */
public class Employee {
	/**
	 * The name of employee
	 */
	private String name;
	/**
	 * <pre>
	 * The level of employee
	 * 
	 * reference: {@link EmployeeLevel}
	 * </pre>
	 */
	private int level;
	/**
	 * The status of employee is free or busy
	 */
	private boolean free = true;

	private CallHandler callHandler;
	
	public Employee(String name, EmployeeLevel employPosition, CallHandler callHandler) {
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
	
	/**
	 * The action that employee receive the call
	 * 
	 * @param call
	 */
	public void receiveCall(Call call) {
		this.free = false;
		System.out.println("---> [" + name + "] receive [" + call.getId() + "]");
	}
	
	/**
	 * The action that employee handled the call
	 * 
	 * @param call
	 */
	public void callHandled(Call call) {
		System.out.println("<--- [" + name + "] handled [" + call.getId() + "]");
		call.disconnect(name);
		this.free = true;
		callHandler.getNextCall(this);
	}

}
