package apiGateway.authentication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.client.RestTemplate;

import DTO.CustomUserDTO;

import org.springframework.http.HttpMethod;

@Configuration
@EnableWebFluxSecurity
public class ApiGatewayAuthentication {

    @Bean
	public MapReactiveUserDetailsService userDetailsService(BCryptPasswordEncoder encoder) {

		List<UserDetails> users = new ArrayList<>();
		List<CustomUserDTO> usersFromDatabase;

		ResponseEntity<CustomUserDTO[]> response = 
		    new RestTemplate().getForEntity("http://localhost:8770/users-service/users", CustomUserDTO[].class);

		usersFromDatabase = Arrays.asList(response.getBody());

		for (CustomUserDTO cud: usersFromDatabase) {
			users.add(User.withUsername(cud.getEmail())
					.password(encoder.encode(cud.getPassword()))
					.roles(cud.getRole())
					.build());
		}

		return new MapReactiveUserDetailsService(users);
	}

	@Bean
	public BCryptPasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityWebFilterChain filterChain(ServerHttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeExchange()
		.pathMatchers(HttpMethod.GET, "/users-service/**").permitAll()
		.pathMatchers(HttpMethod.DELETE, "/users-service/**").hasRole("OWNER")
		.pathMatchers(HttpMethod.PUT, "/users-service/**").hasAnyRole("OWNER","ADMIN")
		.pathMatchers(HttpMethod.POST, "/users-service/**").hasAnyRole("OWNER","ADMIN")
		.pathMatchers("/currency-exchange/**").permitAll()
		.pathMatchers("/currency-conversion/**").hasRole("USER")
		.pathMatchers("/bank-account/**").hasRole("ADMIN")
		.pathMatchers("/crypto-wallet/**").hasRole("ADMIN")
		.pathMatchers("/crypto-exchange/**").permitAll()
		.pathMatchers("/crypto-conversion/**").hasRole("USER")		
		.and()
		.httpBasic();

		return http.build();
	}
    
}
