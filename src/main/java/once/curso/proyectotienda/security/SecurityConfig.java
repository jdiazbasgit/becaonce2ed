package once.curso.proyectotienda.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.Data;
import once.curso.proyectotienda.services.UserDetailLoginService;

@SuppressWarnings("deprecation")
@Data
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailLoginService userDetailLoginService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests().antMatchers("/login").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/documentsTypes/*").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/documentsTypes").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/documentsTypesPaginado").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/cardTypes/*").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/cardTypes").permitAll();

		http.authorizeHttpRequests().antMatchers("/once/profiles/*").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/profiles").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/profilesPaginado").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/products/*").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/products").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/productsPaginado").permitAll();
		
		http.authorizeHttpRequests().antMatchers("/once/existingProducts/*").permitAll();
		
		http.authorizeHttpRequests().antMatchers("/once/usersPaginado").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/roles/*").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/roles").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/configurations/*").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/configurations").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/configurationsPaginado").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/users").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/users/*").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/roles").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/usersPaginado").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/categories/*").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/categories").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/subcategories/*").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/subcategories").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/soldProducts/*").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/soldProducts").permitAll();
		http.authorizeHttpRequests().antMatchers("/once/soldProductsPaginado").permitAll();

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
