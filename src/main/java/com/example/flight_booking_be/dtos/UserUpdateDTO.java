package com.example.flight_booking_be.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserUpdateDTO {
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
