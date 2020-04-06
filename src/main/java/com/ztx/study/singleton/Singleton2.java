package com.ztx.study.singleton;

public class Singleton2 {
	
	private static Singleton2 INSTANCE = null;
	
	static{
		INSTANCE = new Singleton2();
	}
	
	private Singleton2(){
		
	}
	
	public static Singleton2 getInstance(){
		return INSTANCE;
	}
}
