package com.ztx.study.base;

public class Son extends Father {

	private int age = 3;
	
	static{
		System.out.println("ssssssssssss");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "Son [age=" + age + "]";
	}

	@Override
	public void method1() throws NullPointerException{
		
	}
}
