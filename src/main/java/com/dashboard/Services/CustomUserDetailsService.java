package com.dashboard.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.dashboard.Entities.Role;
import com.dashboard.Repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.dashboard.Entities.User appUser = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("No se encontro el usuario"));
        System.out.print("User: "+appUser);
        return User.builder()
                   .username(appUser.getUsername())
                   .password(encoder.encode(appUser.getPassword()))
                   .roles(appUser.getRoles().stream()
                                 .map(Role::getName)
                                 .toArray(String[]::new))
                   .build();
    }
}

