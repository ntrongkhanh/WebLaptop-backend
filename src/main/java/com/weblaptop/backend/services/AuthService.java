package com.weblaptop.backend.services;

import com.weblaptop.backend.models.DTO.JwtResponse;
import com.weblaptop.backend.models.ENTITY.CartEntity;
import com.weblaptop.backend.models.ENTITY.OrdersEntity;
import com.weblaptop.backend.models.ENTITY.User;
import com.weblaptop.backend.repositories.CartRepository;
import com.weblaptop.backend.repositories.UserRepository;
import com.weblaptop.backend.security.jwt.JwtUtils;
import com.weblaptop.backend.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    private CartRepository cartRepository;
    public ResponseEntity<Map<String,Object>> create(User user){
        try {
            user.setAdmin(false);
            user.setPassword(encoder.encode(user.getPassword()));
            user=userRepository.save(user);
            CartEntity cartEntity=new CartEntity();
            cartEntity.setUser(user);
            cartEntity=cartRepository.save(cartEntity);
            Map<String, Object> response = new HashMap<>();
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // login
    public ResponseEntity<?> login(User user){
        Optional<User> userOptional=userRepository.findByEmail(user.getEmail());
        if (!userOptional.isPresent())
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        userOptional.get().setToken(jwt);
        userRepository.save(userOptional.get());
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return ResponseEntity.ok(
                new JwtResponse(jwt,
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getIsAdmin()));
    }
    public ResponseEntity<Map<String,Object>> logout(User user){
        try {
            Optional<User> userOptional=userRepository.findByEmail(user.getEmail());
            if (!userOptional.isPresent())
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            userOptional.get().setToken("");
            user=userRepository.save(userOptional.get());
            Map<String, Object> response = new HashMap<>();
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
