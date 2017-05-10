package com.genesis.test;

/**
 * ProductManager 
 */
public class ProductManager extends Employee {
	/**
	 * Define the level of ProductManager
	 */
	private static final EmployeeLevel empPos = EmployeeLevel.ProductManager;
	/**
	 * Define the name of ProductManager
	 */
	private static final String name = "ProductManager";

	public ProductManager(CallHandler callHandler) {
		super(name, empPos, callHandler);
	}

}
