package com.example.flight_booking_be.services.booking;

import com.example.flight_booking_be.dtos.BookingDTO;
import com.example.flight_booking_be.entities.Booking;

import java.util.List;

public interface IBookingService {
    List<Booking> booking(BookingDTO bookingDTO);

}
