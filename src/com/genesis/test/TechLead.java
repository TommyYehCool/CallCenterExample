package com.genesis.test;

/**
 * Technical Lead
 */
public class TechLead extends Employee {
	/**
	 * Define the level of Technical Lead
	 */
	private static final EmployeeLevel empPos = EmployeeLevel.TechnicalLead;
	/**
	 * Define the name of Technical Lead
	 */
	private static final String name = "TechLead";

	public TechLead(CallHandler callHandler) {
		super(name, empPos, callHandler);
	}

}
