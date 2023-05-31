package once.curso.proyectotienda.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.Data;
import once.curso.proyectotienda.entities.User;
import once.curso.proyectotienda.repositories.UserCRUDRepository;

@Data
@Service
public class UserDetailLoginService implements UserDetailsService {

	@Autowired
	private UserCRUDRepository userCRUDRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=getUserCRUDRepository().loadUserByUsername(username);
		
		Set<GrantedAuthority> roles= new HashSet<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(user.getRol().getRol()));
		return new org.springframework.security.core.userdetails.
				User(username, user.getPassword(), user.isEnabled(), true, true, true, roles);
	}
	
	public User getUser(String username) {
		return getUserCRUDRepository().loadUserByUsername(username);
	}

}
