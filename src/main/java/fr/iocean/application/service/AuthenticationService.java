package fr.iocean.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import fr.iocean.application.model.Authority;
import fr.iocean.application.model.User;
import fr.iocean.application.repository.UserRepository;

@Component
public class AuthenticationService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(final String username) {
		User user = userRepository.findByUsername(username);
		if (user != null) {
			List<GrantedAuthority> rules = this.getAuthorities(user);
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), rules);
		}
		throw new UsernameNotFoundException("username.not.found");
	}
	private List<GrantedAuthority> getAuthorities(User user){
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for(Authority authority :  user.getAuthorities()){
			grantedAuthorities.add(new SimpleGrantedAuthority(authority.getCode()));
		}
		return grantedAuthorities;
	}
}