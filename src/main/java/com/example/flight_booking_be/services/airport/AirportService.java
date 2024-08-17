package com.example.flight_booking_be.services.airport;

import com.example.flight_booking_be.entities.Airport;
import com.example.flight_booking_be.repositories.AirportRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService implements IAirportService{

    private final AirportRepo airportRepo;

    @Override
    public List<Airport> getAll() {
        return airportRepo.findAll();
    }

}
