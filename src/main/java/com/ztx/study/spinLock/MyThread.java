package com.ztx.study.spinLock;

public class MyThread extends Thread {
	
	volatile public static int number;
	
	@Override
	public void run(){
		addCount();
	}
	
	public static void addCount(){
		for(int i=0; i<100; i++){
			number++;
			System.out.println(Thread.currentThread().getName() + ",number:"+number);
		}
	}
}
