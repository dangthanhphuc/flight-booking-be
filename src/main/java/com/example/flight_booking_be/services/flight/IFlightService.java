package com.example.flight_booking_be.services.flight;

import com.example.flight_booking_be.entities.Flight;

import java.util.List;

public interface IFlightService {
    List<Flight> getFlightsFollowPlace(Long fromAirportId, Long toAirportId);
}
