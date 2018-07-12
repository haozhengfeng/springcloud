package org.haozf.springcloud;

import org.bouncycastle.asn1.cms.AuthenticatedData;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter{
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/user/registry")
			.permitAll()
			.anyRequest()
			.authenticated();
	}

}
