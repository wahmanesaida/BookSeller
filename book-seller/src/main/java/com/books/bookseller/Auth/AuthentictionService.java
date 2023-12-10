package com.books.bookseller.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.books.bookseller.Config.JwtService;
import com.books.bookseller.Entity.Role;
import com.books.bookseller.Entity.User;
import com.books.bookseller.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthentictionService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // this method allow us to create user save it to the database and return the token
    public AuthenticationResponse register(RegisterRequest request){
        var user=User.userBuilder()
            .username(request.getUsername())
            .name(request.getName())
            .password(passwordEncoder.encode(request.getPassword()))
           
            .role(Role.USER)
            .build();
        userRepository.save(user);
       var  jwtToken= jwtService.generateToken(user);
       
        return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
            )
        );
        var user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        var jwttoken= jwtService.generateToken(user);
        return AuthenticationResponse.builder()
            .token(jwttoken)
            .build();


    }
    
}
