package com.ztx.study.ProdCustom;

public class MyShareData {

	int number = 0;
	
	public synchronized void add(){
		while(number != 0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		number++;
		System.out.println(Thread.currentThread().getName() + "do add "+number);
		this.notifyAll();
	}
	
	public synchronized void dete(){
		while(number == 0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		number--;
		System.out.println(Thread.currentThread().getName() + "do dete "+number);
		this.notifyAll();
	}
}
