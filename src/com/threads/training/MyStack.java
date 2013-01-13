package com.threads.training;

public class MyStack {

	public int max_stack;
	public Integer[] stack;
	public int top_idx;
	public int count;
	
	public MyStack () {
		max_stack = 10;
		count = 0;
		top_idx = -1;
		stack = new Integer[max_stack];
	}
	
	public synchronized void pop (String name) {
		if (count>0) {
			count--;
			System.out.println("stack["+ top_idx +"] Popped " + stack[top_idx] + " ---> " + name);
			top_idx--;
		}
	}
	
	public synchronized void push (int elem, String name) {
		if (count<10) {
			count++;
			top_idx++;
			stack[top_idx] = elem;
			System.out.println("stack["+ top_idx +"] Pushed " + elem + " ---> " + name);
		}
	}
	
	public static void main (String[] args) {
				
		MyStack S = new MyStack();
		
		Pusher pusher1 = new Pusher(S,"pusher1");
		Popper popper1 = new Popper(S,"popper1");	
		Pusher pusher2 = new Pusher(S,"pusher2");
		
		pusher1.start();
		popper1.start();
		pusher2.start();
		
	}
}
