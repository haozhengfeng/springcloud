package org.haozf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@Configuration
@EnableAutoConfiguration
@EnableAdminServer
@EnableDiscoveryClient
public class AdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServerApplication.class, args);
	}
	
    @Configuration
    public static class SecuritySecureConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
        	http.csrf().disable();

        	http.formLogin()
        		.loginPage("/login.html")
        		.loginProcessingUrl("/login")
        		.permitAll()
        		.and()
        	
        		.logout().deleteCookies("remove").logoutSuccessUrl("/login.html")
        		.and()
        	
        	
        		.authorizeRequests()
        		.antMatchers("/login.html","/**/**.css","/img/**","/third-party/**")
        		.permitAll()
	        	.and()
	        	
	        	.authorizeRequests().antMatchers("/**").authenticated()
	        	.and()
        	
	        	.httpBasic();
        	
        	
        }
    }

}
