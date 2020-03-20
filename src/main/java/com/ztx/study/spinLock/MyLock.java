package com.ztx.study.spinLock;

import java.util.concurrent.atomic.AtomicReference;

public class MyLock {
	
	AtomicReference<Thread> refer = new AtomicReference<Thread>();

	public void myLock(){
		Thread thread = Thread.currentThread();
		while(!refer.compareAndSet(null, thread)){
			
		}
	}
	
	public void myUnLock(){
		Thread thread = Thread.currentThread();
		refer.compareAndSet(thread, null);
	}
	
	public static void main(String args[]){
		MyLock lock = new MyLock();
		MyThread[] threadArray = new MyThread[1000];
		for(int i=0; i<1000; i++){
			threadArray[i] = new MyThread();
		}
		for(int i=0; i<1000; i++){
			threadArray[i].start();
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(MyThread.number);
	}
}
