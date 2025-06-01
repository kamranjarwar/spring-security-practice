package com.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;




@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
		   .csrf().disable()
		   .authorizeRequests()
		   .antMatchers("/public/**").hasRole("NORMAL")
		   .antMatchers("/user/**").hasRole("ADMIN")
		   .antMatchers("/signin").permitAll()
		   .anyRequest()
		   .authenticated()
		   .and()
		   .formLogin()
		   .loginPage("/signin")
		   .loginProcessingUrl("/dologin")
		   .defaultSuccessUrl("/user/");
		
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("USER").password(this.encoder().encode("123")).roles("NORMAL");
		
		auth.inMemoryAuthentication().withUser("kami").password(this.encoder().encode("123")).roles("ADMIN"); 
	}

	
	@Bean
   public PasswordEncoder encoder() {
	   
	   return new BCryptPasswordEncoder(10);
   }
	
	

}
