package com.flight_reservation_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.flight_reservation_app.entity.User;
import com.flight_reservation_app.repository.UserRepository;

//build in interface(UserDetaislService) inside the Spring security jar classes which helps in Granting Authority
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user1 = userRepo.findByEmail(username);
		if (user1 == null) {
			new UsernameNotFoundException("User Not found" + user1);
		}
		return new org.springframework.security.core.userdetails.User(user1.getEmail(), user1.getPassword(),
				user1.getRoles());
	}

}
