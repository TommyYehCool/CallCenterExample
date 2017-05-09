package com.genesis.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CallHandler {
	private static final int TOTAL_LEVELS = EmployLevel.values().length;

	@SuppressWarnings("unchecked")
	private ArrayList<Employee>[] currentEmployeeWithLevel = new ArrayList[TOTAL_LEVELS];

	@SuppressWarnings("unchecked")
	private Queue<Call>[] incomingCallsQueues = new LinkedList[TOTAL_LEVELS];

	public CallHandler(int numOfFreshers) {
		// create freshers
		ArrayList<Employee> freshers = new ArrayList<>(numOfFreshers);
		for (int i = 1; i <= numOfFreshers; i++) {
			freshers.add(new Fresher("Fresher_" + i, this));
		}
		currentEmployeeWithLevel[0] = freshers;

		// create 1 technical lead
		ArrayList<Employee> tls = new ArrayList<>(1);
		tls.add(new TechLead(this));
		currentEmployeeWithLevel[1] = tls;

		// create 1 product manager
		ArrayList<Employee> pms = new ArrayList<>(1);
		pms.add(new ProductManager(this));
		currentEmployeeWithLevel[2] = pms;

		// create incomingCallsQueues instances
		for (int i = 0; i < TOTAL_LEVELS; i++) {
			incomingCallsQueues[i] = new LinkedList<Call>();
		}
	}

	private Employee getCallHandler(Call call) {
		for (int level = call.getLevel(); level < TOTAL_LEVELS; level++) {
			ArrayList<Employee> employeeLevel = currentEmployeeWithLevel[level];
			for (Employee emp : employeeLevel) {
				if (emp.isFree()) {
					return emp;
				}
			}
		}
		return null;
	}

	// routes the call to an available employee, or saves in a queue if no employee available
	public void dispatchCall(Call call) {
		// try to route the call to an employee with minimal level
		Employee emp = getCallHandler(call);
		if (emp != null) {
			emp.receiveCall(call);
			employeeCommunicating(emp.getName());
			emp.callHandled(call);
		} else {
			// place the call into corresponding incoming calls queue according to its level
			call.notifyCallerToWait();
			incomingCallsQueues[call.getLevel()].add(call);
		}
	}

	private void employeeCommunicating(String empName) {
		System.out.println("@@@@ [" + empName + "] communicating @@@@");
		Random ran = new Random();
		int ranNum = ran.nextInt(5) + 1;
		try {
			Thread.sleep(1000 * ranNum);
		} catch (InterruptedException e) {
		}
	}

	// employee got free, look for a waiting call he/she can serve
	public void getNextCall(Employee emp) {
		// check the queues, starting from the highest level this employee can serve
		for (int level = emp.getLevel(); level >= 0; level--) {
			Queue<Call> que = incomingCallsQueues[level];
			Call call = que.poll(); // remove the first call, if any
			if (call != null) {
				emp.receiveCall(call);
				return;
			}
		}
	}
}