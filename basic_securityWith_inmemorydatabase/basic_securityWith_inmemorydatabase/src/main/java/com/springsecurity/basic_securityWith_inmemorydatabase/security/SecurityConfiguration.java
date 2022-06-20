package com.springsecurity.basic_securityWith_inmemorydatabase.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
@Override
	protected void configure(HttpSecurity http) throws Exception {
	
	http 
	.csrf().disable()
	.authorizeRequests()
	.antMatchers("/signin").permitAll()
	.anyRequest()
	.authenticated()
	.and()
//	.httpBasic();
	.formLogin()
	.loginPage("/signin")
	.loginProcessingUrl("/dologin")
	.defaultSuccessUrl("/home");


	}	


@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
	
	
	
	auth.inMemoryAuthentication().withUser("deepak").password(this.passwordEncoder().encode("123#deepak")).roles("user");
	auth.inMemoryAuthentication().withUser("govind").password(this.passwordEncoder().encode("123#govind")).roles("user");
	}



//            @Bean
//            public PasswordEncoder passwordEncoder() {
//            	return  NoOpPasswordEncoder.getInstance();
//            }
            
            
            @Bean
           public BCryptPasswordEncoder  passwordEncoder() {
            	return new BCryptPasswordEncoder(10);
            	
            }

}
