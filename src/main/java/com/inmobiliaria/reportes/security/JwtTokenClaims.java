package com.inmobiliaria.reportes.security;

import java.util.List;

public class JwtTokenClaims {
    private String sub;
    private List<String> roles;


    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
