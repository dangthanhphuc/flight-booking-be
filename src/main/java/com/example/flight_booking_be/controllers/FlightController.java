package com.example.flight_booking_be.controllers;

import com.example.flight_booking_be.entities.Flight;
import com.example.flight_booking_be.responses.FlightResponse;
import com.example.flight_booking_be.responses.Response;
import com.example.flight_booking_be.services.flight.IFlightService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/flights")
public class FlightController {

    private final IFlightService flightService;

    @GetMapping("")
    private ResponseEntity<Response<List<FlightResponse>>> getFlights() {
        List<Flight> flights = flightService.getAll();

        Response<List<FlightResponse>> response;
        if(flights.isEmpty()) {

            response = new Response<>(
                    "Flights not found !",
                    HttpStatus.NOT_FOUND.value(),
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        response = new Response<>(
                "Flights get successfully !",
                HttpStatus.OK.value(),
                flights.stream().map(FlightResponse::fromFlight).toList()
        );

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/search")
    private ResponseEntity<Response<List<FlightResponse>>> getFlightsFollowPlace(
            @RequestParam(name = "from_airport_id") Long fromAirportId,
            @RequestParam(name = "to_airport_id") Long toAirportId
    ) {
        List<Flight> flights = flightService.getFlightsFollowPlace(fromAirportId, toAirportId);

        Response<List<FlightResponse>> response;
        if(flights.isEmpty()) {

            response = new Response<>(
                    "Flights not found !",
                    HttpStatus.NOT_FOUND.value(),
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        response = new Response<>(
                "Flights get successfully !",
                HttpStatus.OK.value(),
                flights.stream().map(FlightResponse::fromFlight).toList()
        );

        return ResponseEntity.ok().body(response);
    }



}
