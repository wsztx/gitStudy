package com.ztx.study.ProdCustom;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class MyResource {

	volatile private boolean flag = true;
	
	BlockingQueue<String> block = null;
	
	public MyResource(BlockingQueue<String> block){
		this.block = block;
	}
	
	public void product() throws InterruptedException{
		String data = "我的资源";
		boolean result;
		while(flag){
			result = block.offer(data, 2, TimeUnit.SECONDS);
			if(result){
				System.out.println(Thread.currentThread().getName()+" 生产资源成功");
			}else{
				System.out.println(Thread.currentThread().getName()+" 生产资源失败");
			}
			Thread.sleep(1000);
		}
	}
	
	public void customer() throws InterruptedException{
		String result = null;
		while(flag){
			result = block.poll(2, TimeUnit.SECONDS);
			if(null == result){
				flag = false;
				System.out.println(Thread.currentThread().getName()+" 消费资源失败");
				return;
			}else{
				System.out.println(Thread.currentThread().getName()+" 消费资源成功");
			}
			Thread.sleep(1000);
		}
	}
	
	public void stop(){
		flag = false;
	}
}
