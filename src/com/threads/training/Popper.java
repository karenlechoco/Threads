package com.threads.training;

public class Popper extends Thread {

	public MyStack stack;
	private String name;
	
	public Popper (MyStack S, String name) {
		stack = S;
		this.name = name;
	}
	
	@Override
	public void run() {
		int count = stack.count;
		while (count > 0) {
			count--;
			stack.pop(name);
		}
			
	}
}
