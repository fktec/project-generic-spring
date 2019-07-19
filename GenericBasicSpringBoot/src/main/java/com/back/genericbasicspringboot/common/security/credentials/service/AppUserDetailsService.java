package com.back.genericbasicspringboot.common.security.credentials.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back.genericbasicspringboot.common.security.credentials.model.AppUser;
import com.back.genericbasicspringboot.common.security.credentials.model.Role;
import com.back.genericbasicspringboot.common.security.credentials.repository.AppUserDetailsRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AppUserDetailsRepository repository;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> appUserOptional = repository.findByEmail(username);
		AppUser appUser = appUserOptional.get();
		
		return new User(appUser.getEmail(), appUser.getPassword(), getRoles(appUser));
	}
	
	private Collection<? extends GrantedAuthority> getRoles(AppUser user) {
		Set<SimpleGrantedAuthority> roles = new HashSet<>();
		List<Role> userRoles = user.getRoles();
		
		userRoles.forEach(role ->
				roles.add(new SimpleGrantedAuthority(role.getDescription().toUpperCase())));
		
		return roles;
	}

}
