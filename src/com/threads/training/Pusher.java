package com.threads.training;

public class Pusher extends Thread {

	public MyStack S;
	private String name;
	
	public Pusher (MyStack S, String name) {
		this.S = S;
		this.name = name;
	}
	
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			S.push(i+10, name);
		}
	}

	
	
}
