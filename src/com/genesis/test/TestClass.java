package com.genesis.test;

public class TestClass {
	public static void main(String[] args) {
		final int numOfFreshers = 5;

		CallHandler callHandler = new CallHandler(numOfFreshers);
		
		int id = 1;
		
		Call[] incomingCalls = new Call[] {
			new Call(id++, EmployLevel.Fresher),
			new Call(id++, EmployLevel.Fresher),
			new Call(id++, EmployLevel.TechnicalLead),
			new Call(id++, EmployLevel.ProductManager),
			new Call(id++, EmployLevel.Fresher),
			new Call(id++, EmployLevel.Fresher),
			new Call(id++, EmployLevel.Fresher),
			new Call(id++, EmployLevel.Fresher),
		};
		
		for (Call incomingCall : incomingCalls) {
			new Thread(() -> {
				callHandler.dispatchCall(incomingCall);
			}).start();
		}
	}
}
