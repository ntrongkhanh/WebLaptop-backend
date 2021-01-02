package com.weblaptop.backend.models.DTO;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private boolean isAdmin;

    public JwtResponse() {
    }

    public JwtResponse(String token, Long id, String username, boolean isAdmin) {
        this.token = token;
        this.type = type;
        this.id = id;
        this.username = username;
        this.isAdmin=isAdmin;
    }

    public boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}