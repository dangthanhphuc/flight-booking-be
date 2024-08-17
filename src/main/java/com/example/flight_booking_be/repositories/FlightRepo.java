package com.example.flight_booking_be.repositories;

import com.example.flight_booking_be.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {
    @Query(value = "SELECT f.* FROM flights f WHERE f.from_airport_id = :from_airport_id AND f.to_airport_id = :to_airport_id ", nativeQuery = true)
    List<Flight> getFlightsFollowPlace(@Param("from_airport_id") Long fromAirportId, @Param("to_airport_id") Long toAirportId);
}
