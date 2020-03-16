package com.ztx.study.aopStudy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyHandler implements InvocationHandler {

	private Object object;//代理对象
	
	public DynamicProxyHandler(Object object){
		this.object = object;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before do somthing");
		return method.invoke(object, args);
	}

	
	public static void main(String args[]){
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		DynamicInterfaceImpl myBean = new DynamicInterfaceImpl();
		DynamicInterface proxy = (DynamicInterface)Proxy.newProxyInstance(DynamicInterface.class.getClassLoader(), new Class[]{DynamicInterface.class}, new DynamicProxyHandler(myBean));
		
		proxy.doSomthing();
	}
}
