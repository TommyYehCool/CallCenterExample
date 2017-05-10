package com.genesis.test;

/**
 * Fresher 
 */
public class Fresher extends Employee {
	/**
	 * Define the level of Fresher
	 */
	private static final EmployeeLevel empPos = EmployeeLevel.Fresher;

	public Fresher(String name, CallHandler callHandler) {
		super(name, empPos, callHandler);
	}

}
