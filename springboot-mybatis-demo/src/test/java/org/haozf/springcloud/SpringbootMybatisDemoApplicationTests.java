package org.haozf.springcloud;

import java.net.URL;

import javax.annotation.Resource;

import org.haozf.springcloud.redis.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisDemoApplicationTests {

	@LocalServerPort
	private int port;
	private URL base;
	
	@Resource
	private TestRestTemplate template;
	
	@Autowired
	RedisDao redisDao;
	
	public void setUp() throws Exception{
		this.base = new URL("http://localhost:"+port+"/hello");
	}
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void getHello() throws Exception{
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		System.out.println(response.getBody());
	}
	
	@Test
	public void testRedis() {
		redisDao.setKey("name", "hao");
		redisDao.setKey("age", "18");;
		System.out.println(redisDao.getValue("name"));
		System.out.println(redisDao.getValue("age"));
	}

}
