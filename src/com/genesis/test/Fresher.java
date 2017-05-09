package com.genesis.test;

public class Fresher extends Employee {

	private static final EmployLevel empPos = EmployLevel.Fresher;

	public Fresher(String name, CallHandler callHandler) {
		super(name, empPos, callHandler);
	}

}
