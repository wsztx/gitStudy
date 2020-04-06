package com.ztx.study.base;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class Father implements BeanPostProcessor, BeanNameAware {
	
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	@Override
	public String toString() {
		return "Father [age=" + age + "]";
	}

	public void method1() throws Exception{
		
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization start.");
		return bean;
	}

	@Override
	public void setBeanName(String name) {
		
	}
}
