package com.dashboard.Implementations;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.dashboard.Entities.User;
import com.dashboard.Repositories.UserRepository;
import com.dashboard.Services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> findByUsername(String username) {
    	System.out.print("username found?: " + userRepository.findByUsername(username));
    	System.out.print("abc123 codificada: " + passwordEncoder.encode("abc123"));
        //System.out.print("Contrasena almacenada: " + appUser.getPassword());
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        // Codificar contraseña antes de guardar
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
