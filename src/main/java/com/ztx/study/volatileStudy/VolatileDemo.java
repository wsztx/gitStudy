package com.ztx.study.volatileStudy;

class MyWork{
	volatile int number = 20;
	
	public void changeNum(){
		this.number = 60;
	}
}

public class VolatileDemo {

	public static void main(String args[]){
		final MyWork work = new MyWork();
		
		Thread thread = new Thread("AAA"){
			public void run(){
				System.out.println(Thread.currentThread().getName() + " start.");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				work.changeNum();
				System.out.println(Thread.currentThread().getName() + " value change.");
			}
		};
		thread.start();
		
		while(work.number == 20){
			
		}
		System.out.println(Thread.currentThread().getName() + " change success, value:" + work.number);
	}
}
