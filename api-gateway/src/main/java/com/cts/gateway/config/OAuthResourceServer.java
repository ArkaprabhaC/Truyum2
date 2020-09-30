package com.cts.gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import lombok.NoArgsConstructor;

/**
 * Resource server for the application
 * @author Arkaprabha
 *
 */
@Configuration
@EnableResourceServer
@NoArgsConstructor
public class OAuthResourceServer extends ResourceServerConfigurerAdapter{

	/**
	 * Resource Server Config
	 */
	@Override
	public void configure(final HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			
			.antMatchers("/oauth/**").permitAll()
			.antMatchers("/product/all").hasAnyRole("ADMIN","CUSTOMER")
			.antMatchers("/product/{id}").hasAnyRole("ADMIN","CUSTOMER")
			.antMatchers("/product/**").hasRole("ADMIN")
			.antMatchers("/cart/**").hasRole("CUSTOMER")
			.and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	
}
