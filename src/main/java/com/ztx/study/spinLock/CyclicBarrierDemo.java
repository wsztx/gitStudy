package com.ztx.study.spinLock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	
	public static void main(String args[]) throws Exception{
		final CyclicBarrier cy = new CyclicBarrier(10, new Thread("myThread"){
			@Override
			public void run(){
				System.out.println(Thread.currentThread().getName() + " myThread end.");
			}
		});
		
		for(int i=0; i<10; i++){
			Thread thread = new Thread("t"+i){
				@Override
				public void run(){
					System.out.println(Thread.currentThread().getName() + " end.");
					try {
						cy.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " jixu.");
				}
			};
			thread.start();
		}
	}
}
