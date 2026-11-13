package br.com.trilhas.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.trilhas.api.security.JwtFilter;
import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    	http
        .csrf(csrf -> csrf.disable())
        .cors(cors -> {})
        .authorizeHttpRequests(auth -> auth
        	    .requestMatchers(
        	        "/api/auth/**",
        	        "/swagger-ui/**",
        	        "/v3/api-docs/**"
        	    ).permitAll()
        	    .requestMatchers(HttpMethod.POST, "/api/usuarios").permitAll()
        	    .anyRequest().authenticated()
        	)
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class).exceptionHandling(ex -> ex
        	    .accessDeniedHandler((request, response, exception) -> {
        	        exception.printStackTrace();
        	        response.sendError(403, exception.getMessage());
        	    })
        	);

        return http.build();
    }
}