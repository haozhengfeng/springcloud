package org.haozf.springcloud;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

	Logger logger = LoggerFactory.getLogger(HiController.class);
	
	@Value("${server.port}")
	String port;
	
	@RequestMapping("/hi")
	public String home() {
		return "hi:"+",i am from port:" +port;
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String hello() {
		return "hello you!";
	}
	
	public OAuth2Authentication getPrinciple(OAuth2Authentication oAuth2Authentication,Principal principal,Authentication authentication) {
		System.out.println(oAuth2Authentication.getUserAuthentication().getAuthorities().toString());
		System.out.println(oAuth2Authentication.toString());
		System.out.println("principal.toString()"+principal.toString());
		System.out.println("principal.getName()"+principal.getName());
		System.out.println("authentication:"+authentication.getAuthorities().toString());
		return oAuth2Authentication;
	}
	
}
