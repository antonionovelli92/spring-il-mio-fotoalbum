package org.java.fotoalbum.auth.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AuthConfiguration {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return 
			http.csrf(c -> c.disable())
				.authorizeHttpRequests(a -> a
					.requestMatchers("/fotoalbum/**").hasAnyAuthority("USER", "ADMIN")
					.requestMatchers("/categorie/**").hasAuthority("ADMIN")
					.requestMatchers("/messaggi/**").hasAnyAuthority("USER", "ADMIN")
			        .requestMatchers("/**", "/api/**").permitAll()
			).formLogin(f -> f.defaultSuccessUrl("/fotoalbum").permitAll()
			).logout(l -> l.logoutSuccessUrl("/fotoalbum")
			).build();
	}
}
