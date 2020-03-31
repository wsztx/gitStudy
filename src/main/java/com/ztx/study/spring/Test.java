package com.ztx.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ztx.study.base.Father;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		Father father = (Father)ctx.getBean("test");
		System.out.println(father);
	}

}
