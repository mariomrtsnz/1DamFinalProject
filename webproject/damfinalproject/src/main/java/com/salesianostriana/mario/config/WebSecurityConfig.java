package com.salesianostriana.mario.config;

import org.dontpanic.spanners.springmvc.config.BCryptPasswordEncoder;
import org.dontpanic.spanners.springmvc.config.PasswordEncoder;
import org.dontpanic.spanners.springmvc.services.RestUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfig {
	private static final String[] PERMIT_ALL_URLS = { "/", "/css/**", "/img/**", "/js/**", "/signup", "/version.txt" };

	@Autowired
	private RestUserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(PERMIT_ALL_URLS).permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").failureUrl("/login?error=1").defaultSuccessUrl("/displaySpanners").permitAll()
				.and().logout().permitAll().and().csrf().disable();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(configurePasswordEncoder());
	}

	@Bean
	public PasswordEncoder configurePasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
