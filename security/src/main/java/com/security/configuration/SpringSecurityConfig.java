package com.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		// Chaine de filtres.
		http.authorizeHttpRequests(authorizeRequests -> authorizeRequests
						.requestMatchers("/admin").hasRole("ADMIN")
						.requestMatchers("/user").hasRole("USER")
						.requestMatchers("/administration").hasRole("ADMIN")
						.requestMatchers("/accueil").permitAll()
						.anyRequest().authenticated()
				)
				.formLogin(formLogin -> formLogin
						.loginPage("/login")  // Custom login page
						.defaultSuccessUrl("/profile")  // Default success URL after login
						.failureUrl("/login?error=true")  // Error URL in case of login failure
						.permitAll()  // Allow everyone to see the login page
				)
				.logout(logout -> logout
						.logoutSuccessUrl("/accueil")  // URL to redirect to after logout
				);

		return http.build();
	}
	
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	

}
