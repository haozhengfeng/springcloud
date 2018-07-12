package org.haozf.springcloud.controller;

import org.haozf.springcloud.redis.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	RedisDao redisDao;

	@RequestMapping("hello")
	public String hello() {
		redisDao.setKey("name", "hao");
		redisDao.setKey("age", "18");;
		System.out.println(redisDao.getValue("name"));
		System.out.println(redisDao.getValue("age"));
		return "hello world!";
	}
	
}
