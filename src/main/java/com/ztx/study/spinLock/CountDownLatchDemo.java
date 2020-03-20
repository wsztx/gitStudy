package com.ztx.study.spinLock;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	
	public static void main(String args[]) throws Exception{
		final CountDownLatch counrDown = new CountDownLatch(10);
		
		for(int i=0; i<10; i++){
			Thread thread = new Thread("t"+i){
				@Override
				public void run(){
					System.out.println(Thread.currentThread().getName() + " end.");
					counrDown.countDown();
				}
			};
			thread.start();
		}
		
		counrDown.await();
		System.out.println(Thread.currentThread().getName() + " end.");
	}
}
