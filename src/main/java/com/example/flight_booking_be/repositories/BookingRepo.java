package com.example.flight_booking_be.repositories;

import com.example.flight_booking_be.entities.Booking;
import com.example.flight_booking_be.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepo extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);
}
