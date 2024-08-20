package com.example.flight_booking_be.responses;

import com.example.flight_booking_be.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String username;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private LocalDate dob;
    Set<String> roles;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String email;

    @JsonProperty("citizen_identification")
    private String citizenIdentification;

    public static UserResponse fromUser(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .dob(user.getDob())
                .citizenIdentification(user.getCitizenIdentification())
                .build();
    }


}
