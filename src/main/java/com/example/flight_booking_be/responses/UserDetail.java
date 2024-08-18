package com.example.flight_booking_be.responses;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserDetail extends User {

    public UserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities){
        super(username, password, authorities);
    }

}
