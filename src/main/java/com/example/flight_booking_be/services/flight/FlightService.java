package com.example.flight_booking_be.services.flight;

import com.example.flight_booking_be.entities.Flight;
import com.example.flight_booking_be.repositories.FlightRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService implements IFlightService{

    private final FlightRepo flightRepo;

    @Override
    public List<Flight> getAll() {
        return flightRepo.findAll();
    }

    @Override
    public List<Flight> getFlightsFollowPlace(Long fromAirportId, Long toAirportId) {
        return flightRepo.getFlightsFollowPlace(fromAirportId, toAirportId);
    }

}
