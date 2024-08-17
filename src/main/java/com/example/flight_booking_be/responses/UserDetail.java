package com.example.flight_booking_be.responses;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserDetail extends User {
    private final String userId;

    public UserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities, String userId){
        super(username, password, authorities);
        this.userId = userId;
    }

    public String getUserId(){
        return userId;
    }
}
