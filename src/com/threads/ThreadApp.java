package com.threads;

public class ThreadApp {
	
	private volatile static  boolean isTerminated = false;
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(() ->  {
			if(isTerminated) {
				for(int i=0; i<10;i++) {
					System.out.println("Runnable 1 "+i);
				}
			}
			
		});
		
		Thread t2 = new Thread(() ->  {
		//	if(isTerminated) {
				for(int i=0; i<10;i++) {
					System.out.println("Runnable 1 "+i);
				}
		//	}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		
		System.out.println("Finished task...");
		
	}
}