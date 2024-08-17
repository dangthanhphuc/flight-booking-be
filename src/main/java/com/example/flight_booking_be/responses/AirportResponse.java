package com.example.flight_booking_be.responses;

import com.example.flight_booking_be.entities.Airport;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirportResponse {

    @JsonProperty("airport_code")
    private String airportCode;

    private String name;

    private String country;

    private String city;

    private String location;

    private int coefficient;

    public static AirportResponse fromAirport(Airport airport) {
        return AirportResponse.builder()
                .airportCode(airport.getAirportCode())
                .name(airport.getName())
                .country(airport.getCountry())
                .city(airport.getCity())
                .location(airport.getLocation())
                .coefficient(airport.getCoefficient())
                .build();
    }
}
