package com.example.flight_booking_be.responses;

import com.example.flight_booking_be.entities.Flight;
import com.example.flight_booking_be.enums.FlightStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightResponse {

    @JsonProperty("flight_number")
    private String flightNumber;

    @JsonProperty("departure_date_time")
    private LocalDateTime departureDateTime;

    @JsonProperty("arrival_date_time")
    private LocalDateTime arrivalDateTime;

    private FlightStatus status;

    @JsonProperty("economy_class")
    private int economyClass;

    @JsonProperty("business_class")
    private int businessClass;

    @JsonProperty("special_class")
    private int specialClass;

    @JsonProperty("economy_price")
    private int economyPrice;

    @JsonProperty("business_price")
    private int businessPrice;

    @JsonProperty("special_price")
    private int specialPrice;

    @JsonProperty("from_airport")
    private AirportResponse fromAirport;

    @JsonProperty("to_airport")
    private AirportResponse toAirport;

    @JsonProperty("plane")
    private PlaneResponse plane;

    public static FlightResponse fromFlight(Flight flight) {
        return FlightResponse.builder()
                .flightNumber(flight.getFlightNumber())
                .departureDateTime(flight.getDepartureDateTime())
                .arrivalDateTime(flight.getArrivalDateTime())
                .status(flight.getStatus())
                .economyClass(flight.getEconomyClass())
                .businessClass(flight.getBusinessClass())
                .specialClass(flight.getSpecialClass())
                .economyPrice(flight.getEconomyPrice())
                .businessPrice(flight.getBusinessPrice())
                .specialPrice(flight.getSpecialPrice())
                .fromAirport(AirportResponse.fromAirport(flight.getFromAirport()))
                .toAirport(AirportResponse.fromAirport(flight.getToAirport()))
                .plane(PlaneResponse.fromPlane(flight.getPlane()))
                .build();
    }

}
