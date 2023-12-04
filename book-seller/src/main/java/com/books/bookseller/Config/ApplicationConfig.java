package com.books.bookseller.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.books.bookseller.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            // retieve the user from the data base
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
               return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not found!"));
            }
            
        };
    }
    
}
