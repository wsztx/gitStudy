package com.ztx.study.ProdCustom;

import java.util.concurrent.ArrayBlockingQueue;

public class ProdCustomDemo2 {

	public static void main(String args[]){
		MyResource res = new MyResource(new ArrayBlockingQueue<>(10));
		Thread thread1 = new Thread("Product"){
			@Override
			public void run(){
				try {
					res.product();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread thread2 = new Thread("Customer"){
			@Override
			public void run(){
				try {
					res.customer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		thread1.start();
		thread2.start();
	}

}
