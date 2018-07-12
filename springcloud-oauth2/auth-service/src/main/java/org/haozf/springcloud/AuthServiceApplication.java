package org.haozf.springcloud;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@SpringBootApplication
@MapperScan("org.haozf.springcloud.**.mapper")
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}
	
	@Autowired
	@Qualifier("datasource")
	private DataSource dataSource;
	
	@Configuration
	@EnableAuthorizationServer
	protected class Oauth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter{
		JdbcTokenStore tokenStore = new JdbcTokenStore(dataSource);
		
		@Autowired
		@Qualifier("authenticationManagerBean")
		private AuthenticationManager authenticationManager;
		
		@Autowired
		private UserServiceDetail userDetailsService;
		
		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			clients.inMemory()
					.withClient("browser")
					.authorizedGrantTypes("refresh_token","password")
					.scopes("ui")
					.and()
					.withClient("service-hi")
					.secret("123456")
					.authorizedGrantTypes("client_credentials","refresh_token","password")
					.scopes("server");
		}
		
		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			endpoints
				.tokenStore(tokenStore)
				.authenticationManager(authenticationManager)
				.userDetailsService(userDetailsService);
		}
		
		@Override
		public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
			security
				.tokenKeyAccess("permitAll()")
				.checkTokenAccess("isAuthenticated");
		}
		
	}
	
	
}
