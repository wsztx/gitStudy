package com.ztx.study.ProdCustom;

public class ProdCustomDemo1 {

	public static void main(String args[]){
		final MyShareData d = new MyShareData();
		Thread t1 = new Thread("生产1"){
			@Override
			public void run(){
				d.add();
			}
		};
		
		Thread t2 = new Thread("消费1"){
			@Override
			public void run(){
				d.dete();
			}
		};
		
		Thread t3 = new Thread("生产2"){
			@Override
			public void run(){
				d.add();
			}
		};
		
		Thread t4 = new Thread("消费2"){
			@Override
			public void run(){
				d.dete();
			}
		};
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
