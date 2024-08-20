package com.example.flight_booking_be.controllers;

import com.example.flight_booking_be.dtos.BookingDTO;
import com.example.flight_booking_be.entities.Booking;
import com.example.flight_booking_be.responses.BookingResponse;
import com.example.flight_booking_be.responses.Response;
import com.example.flight_booking_be.services.booking.IBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/booking")
public class BookingController {

    private final IBookingService bookingService;

    @PostMapping("")
    public ResponseEntity<Response<List<BookingResponse>>> booking(@RequestBody  BookingDTO bookingDTO){
        List<Booking> bookingList = bookingService.booking(bookingDTO);

        Response<List<BookingResponse>> response = new Response<> (
                "Bookings is successfully !",
                HttpStatus.OK.value(),
                bookingList.stream().map(BookingResponse::fromBooking).toList()
        );

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Response<List<BookingResponse>>> getByUserId(@PathVariable("userId") Long userId){
        List<Booking> bookingList = bookingService.getByUserId(userId);

        Response<List<BookingResponse>> response = new Response<> (
                "Bookings is successfully !",
                HttpStatus.OK.value(),
                bookingList.stream().map(BookingResponse::fromBooking).toList()
        );

        return ResponseEntity.ok().body(response);
    }


}
