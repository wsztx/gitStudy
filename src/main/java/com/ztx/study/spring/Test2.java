package com.ztx.study.spring;

import redis.clients.jedis.Jedis;

public class Test2 {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1");
		System.out.println(jedis.get("k1"));
	}

}
