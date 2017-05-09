package com.genesis.test;

public class ProductManager extends Employee {

	private static final EmployLevel empPos = EmployLevel.ProductManager;
	
	private static final String name = "ProductManager";

	public ProductManager(CallHandler callHandler) {
		super(name, empPos, callHandler);
	}

}
