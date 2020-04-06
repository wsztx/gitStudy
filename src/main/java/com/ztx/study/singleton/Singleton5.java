package com.ztx.study.singleton;

public class Singleton5 {
	
	volatile private static Singleton5 INSTANCE = null;
	
	private Singleton5(){
		
	}
	
	public static Singleton5 getInstance(){
		if(INSTANCE == null){
			synchronized (Singleton5.class) {
				if(INSTANCE == null){
					INSTANCE = new Singleton5();
				}
			}
		}
		return INSTANCE;
	}
}
