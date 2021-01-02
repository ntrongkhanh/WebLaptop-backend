package com.weblaptop.backend.security.jwt;


import com.weblaptop.backend.models.ENTITY.User;
import com.weblaptop.backend.repositories.UserRepository;
import com.weblaptop.backend.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class JwtUtils {
  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

  @Autowired
  private UserRepository userRepository;
  @Value("${laptop.app.jwtSecret}")
  private String jwtSecret;

  @Value("${laptop.app.jwtExpirationMs}")
  private int jwtExpirationMs;

  public String generateJwtToken(Authentication authentication) {

    UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

    return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)).signWith(SignatureAlgorithm.HS512, jwtSecret)
        .compact();
  }

  public String getUserNameFromJwtToken(String token) {
    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
  }
  public User getUserByJwtToken(String token){
    Optional<User> user=userRepository.findByEmail(getUserNameFromJwtToken(parseJwt(token)));
    return user.get();
  }
  public boolean isAdmin(String token) {
    token=this.parseJwt(token);
    String username = this.getUserNameFromJwtToken(token);
    Optional<User> userEntity = userRepository.findByEmail(username);
    if (userEntity.get().getAdmin())
      return true;
    return false;
  }

  public String parseJwt(String token){
    if (token.startsWith("Bearer ")) {
      return token.substring(7, token.length());
    }else return null;
  }
  public boolean validateJwtToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
      return true;
    } catch (SignatureException e) {
      logger.error("Invalid JWT signature: {}", e.getMessage());
    } catch (MalformedJwtException e) {
      logger.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      logger.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      logger.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      logger.error("JWT claims string is empty: {}", e.getMessage());
    }

    return false;
  }
}
