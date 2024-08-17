package com.example.flight_booking_be.responses;

import com.example.flight_booking_be.entities.Booking;
import com.example.flight_booking_be.enums.BookingStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Setter
@Getter
public class BookingResponse {

    @JsonProperty("booking_code")
    private String bookingCode;

    private LocalDateTime date;

    private BookingStatus status;

    @JsonProperty("total_amount")
    private float totalAmount;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("date_of_birth")
    private LocalDate dateOfBirth;

    private FlightResponse flight;

    private UserResponse user;

    @JsonProperty("seat_class")
    private SeatClassResponse seatClass;

    public static BookingResponse fromBooking(Booking booking) {
        return BookingResponse.builder()
                .bookingCode(booking.getBookingCode())
                .date(booking.getDate())
                .status(booking.getStatus())
                .totalAmount(booking.getTotalAmount())
                .firstName(booking.getFirstName())
                .lastName(booking.getLastName())
                .dateOfBirth(booking.getDateOfBirth())
                .flight(FlightResponse.fromFlight(booking.getFlight()))
                .user(UserResponse.fromUser(booking.getUser()))
                .seatClass(SeatClassResponse.fromSeatClass(booking.getSeatClass()))
                .build();
    }

}
