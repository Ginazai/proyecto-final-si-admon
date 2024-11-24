package com.dashboard.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.dashboard.Services.CustomUserDetailsService;

@Configuration
public class SecurityConfig {

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll() // Permitir acceso público a auth/*
                .requestMatchers("/images/**").permitAll()
                .anyRequest().authenticated()           // Proteger otras rutas
            )
            .formLogin(form -> form
                    .loginPage("/auth/login")        // Ruta personalizada de login
                    .permitAll()                // Permitir acceso sin autenticación
                    .defaultSuccessUrl("/inicio",true) // Redirigir tras autenticación exitosa
                    //.failureUrl("/login?error") // Redirigir si ocurre un error de autenticación
            )
            .logout(logout -> logout
                .logoutUrl("/auth/logout")        // URL para cerrar sesión
                .logoutSuccessUrl("/auth/login")  // Redirigir tras cerrar sesión
            );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Configurar codificación para contraseñas
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

}
