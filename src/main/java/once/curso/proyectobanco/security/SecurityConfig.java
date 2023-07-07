package once.curso.proyectobanco.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.Data;
import once.curso.proyectobanco.services.UserDetailLoginService;

@Data
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailLoginService userDetailLoginService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests().antMatchers("/login").permitAll();
		//http.authorizeHttpRequests().antMatchers("/once/*").permitAll();
		//http.authorizeHttpRequests().antMatchers("/once/*/*").permitAll();
		http.authorizeHttpRequests().anyRequest().authenticated();
		http.csrf().disable();
		http.cors();
		http.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(getUserDetailLoginService()).passwordEncoder(new BCryptPasswordEncoder(5));
	}
	
}
