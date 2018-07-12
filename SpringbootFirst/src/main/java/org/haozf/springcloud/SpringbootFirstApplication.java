package org.haozf.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)  
@MapperScan("org.haozf.springcloud")
public class SpringbootFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFirstApplication.class, args);
	}
}
