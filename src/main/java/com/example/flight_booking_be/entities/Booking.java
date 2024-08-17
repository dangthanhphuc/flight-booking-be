package com.example.flight_booking_be.entities;


import com.example.flight_booking_be.enums.BookingStatus;
import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "booking_code", nullable = false)
    private String bookingCode;

    @Column(nullable = false)
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BookingStatus status;

    @Column(name = "total_amount", nullable = false)
    private float totalAmount;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "citizen_identification")
    private String citizenIdentification;

    @ManyToOne()
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;

    @ManyToOne()
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @ManyToOne()
    @JoinColumn(name = "seat_class_id", nullable = false)
    private SeatClass seatClass;

}
