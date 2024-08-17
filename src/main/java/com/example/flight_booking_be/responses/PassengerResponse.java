package com.example.flight_booking_be.responses;

import com.example.flight_booking_be.entities.Passenger;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PassengerResponse {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String email;

    @JsonProperty("citizen_identification")
    private String citizenIdentification;

    public static PassengerResponse fromPassenger(Passenger passenger) {
        return PassengerResponse.builder()
                .firstName(passenger.getFirstName())
                .lastName(passenger.getLastName())
                .email(passenger.getEmail())
                .phoneNumber(passenger.getPhoneNumber())
                .citizenIdentification(passenger.getCitizenIdentification())
                .build();
    }
}
