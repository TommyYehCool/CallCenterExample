package com.genesis.test;

public class TestClass {
	public static void main(String[] args) {
		CallHandler callHandler = new CallHandler(5);
		
		Call[] incomingCalls = new Call[] {
			new Call(1, EmployLevel.Fresher),
			new Call(2, EmployLevel.Fresher),
			new Call(3, EmployLevel.TechnicalLead),
			new Call(4, EmployLevel.ProductManager)
		};
		
		for (Call incomingCall : incomingCalls) {
			new Thread(() -> {
				callHandler.dispatchCall(incomingCall);
			}).start();
		}
	}
}
