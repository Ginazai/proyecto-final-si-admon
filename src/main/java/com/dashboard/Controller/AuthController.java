package com.dashboard.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.dashboard.Entities.User;
import com.dashboard.Repositories.UserRepository;
import com.dashboard.Services.ContenidoServicio;
import com.dashboard.Services.UserService;

import org.springframework.stereotype.Controller;

@Controller
public class AuthController {
	
	private final UserService userService;
	
	
	public AuthController(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

	
	@GetMapping("/auth/login")
    public String loginPage(Model model, Authentication authentication) {
		if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/inicio";
        }
		//System.out.print("User: " + userService.findByUsername("TESTUSER"));
		System.out.print("abc123 codificada: " + passwordEncoder.encode("abc123"));
		return "login_app"; 
    }
	
	@GetMapping("/auth/logout")
	public String logout() {
		return "redirect:/auth/login";
	}
   
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }
}
