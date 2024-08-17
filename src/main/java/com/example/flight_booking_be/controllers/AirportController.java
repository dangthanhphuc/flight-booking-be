package com.example.flight_booking_be.controllers;

import com.example.flight_booking_be.entities.Airport;
import com.example.flight_booking_be.responses.AirportResponse;
import com.example.flight_booking_be.responses.Response;
import com.example.flight_booking_be.services.airport.IAirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/airports")
public class AirportController {

    private final IAirportService airportService;

    @GetMapping("")
    public ResponseEntity<Response<List<AirportResponse>>> getAirport() {
        List<Airport> airports = airportService.getAll();

        Response<List<AirportResponse>> response = new Response<>(
                "Airports get successfully !",
                HttpStatus.OK.value(),
                airports.stream().map(AirportResponse::fromAirport).toList()
        );

        return ResponseEntity.ok().body(response);
    }

}
