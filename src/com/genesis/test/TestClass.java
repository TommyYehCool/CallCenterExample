package com.genesis.test;

/**
 * Testing class 
 */
public class TestClass {
	public static void main(String[] args) {
		final int numOfFreshers = 5;

		CallHandler callHandler = new CallHandler(numOfFreshers);
		
		int id = 1;
		
		Call[] incomingCalls = new Call[] {
			new Call(id++, EmployeeLevel.TechnicalLead),
			new Call(id++, EmployeeLevel.TechnicalLead),
			new Call(id++, EmployeeLevel.Fresher),
			new Call(id++, EmployeeLevel.Fresher),
			new Call(id++, EmployeeLevel.ProductManager),
			new Call(id++, EmployeeLevel.Fresher),
			new Call(id++, EmployeeLevel.Fresher),
			new Call(id++, EmployeeLevel.Fresher),
			new Call(id++, EmployeeLevel.ProductManager),
			new Call(id++, EmployeeLevel.Fresher),
		};
		
		for (Call incomingCall : incomingCalls) {
			new Thread(() -> {
				callHandler.dispatchCall(incomingCall);
			}).start();
		}
	}
}
