package com.genesis.test;

public class TechLead extends Employee {

	private static final EmployLevel empPos = EmployLevel.TechnicalLead;
	
	private static final String name = "TechLead";

	public TechLead(CallHandler callHandler) {
		super(name, empPos, callHandler);
	}

}
