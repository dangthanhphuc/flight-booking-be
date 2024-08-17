package com.example.flight_booking_be.repositories;

import com.example.flight_booking_be.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Long> {
}
