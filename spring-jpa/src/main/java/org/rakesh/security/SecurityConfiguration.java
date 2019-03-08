/*package org.rakesh.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends  WebSecurityConfigurerAdapter {
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("rakesh").password("rakzz").roles("ADMIN")
		.and().withUser("azhar").password("arjun").roles("READER");
		
		auth.inMemoryAuthentication().withUser("admin").password("ad").roles("USERS");
	}

	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin().successForwardUrl("/login?error=true").and().;
		http.authorizeRequests().anyRequest().permitAll();
		
		
	}
	
	
}
*/