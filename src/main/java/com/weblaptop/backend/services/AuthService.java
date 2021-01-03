package com.weblaptop.backend.services;

import com.weblaptop.backend.mailConfig.MailService;
import com.weblaptop.backend.models.DTO.JwtResponse;
import com.weblaptop.backend.models.ENTITY.CartEntity;
import com.weblaptop.backend.models.ENTITY.User;
import com.weblaptop.backend.repositories.CartRepository;
import com.weblaptop.backend.repositories.UserRepository;
import com.weblaptop.backend.security.jwt.JwtUtils;
import com.weblaptop.backend.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

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
    @Autowired
    private MailService mailService;
    @Autowired
    private JavaMailSender emailSender;

    public ResponseEntity<Map<String, Object>> create(User user) {
        try {
            Map<String, Object> response = new HashMap<>();
            if (!validEmail(user.getEmail())) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
           Optional<User> optional=userRepository.findByEmail(user.getEmail());
            if (optional.isPresent() && optional.get().getActive()==true) {
                response.put("data", "EMAIL ALREADY EXIST");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            user.setAdmin(false);
            user.setActive(false);
            user.setPassword(encoder.encode(user.getPassword()));
            user = userRepository.saveAndFlush(user);
            CartEntity cartEntity = new CartEntity();
            cartEntity.setUser(user);
            cartEntity = cartRepository.saveAndFlush(cartEntity);

            try {
                String activeToken = UUID.randomUUID().toString();
                mailService.sendConfirmMail(emailSender, user.getEmail(), activeToken);
                createTokenFile(activeToken, user.getEmail());
            } catch (Exception e) {

                userRepository.delete(user);

                response.put("data", "MAILLING FAILED");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("data", "cHỖ NÀY");
            return new ResponseEntity<>(response, HttpStatus.OK);
           // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, Object>> confirm(String token, String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (!user.isPresent())
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        if (user.get().getActive()) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        File file = new File("confirmToken/" + token + "_" + email);
        //     List<String> myList = new ArrayList<>();
        if (!file.exists())
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        try {
            user.get().setActive(true);
            userRepository.save(user.get());
            file.delete();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("data", "Success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // login
    public ResponseEntity<?> login(User user) {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
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

    public ResponseEntity<Map<String, Object>> logout(User user) {
        try {
            Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
            if (!userOptional.isPresent())
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            userOptional.get().setToken("");
            user = userRepository.save(userOptional.get());
            Map<String, Object> response = new HashMap<>();
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void createTokenFile(String token, String email) {
        try {
            File myObj = new File("confirmToken/" + token + "_" + email);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static boolean validEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}
