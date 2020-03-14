package com.threads;

public class Syncrnocized {
	
	private static int count = 0;
	
	
	private static synchronized void increment() {
		count++;
	}
	
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(() -> {
			
			for(int i =0 ;i<100;i++) {
				System.out.println("Thread1 "+i);
				increment();
			}
			
		});
		
		Thread t2 = new Thread(() -> {
			for(int i =0 ;i<100;i++) {
				System.out.println("Thread2 "+i);
				increment();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
			
			System.out.println(count);
			
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
		
		
		
	}

}
