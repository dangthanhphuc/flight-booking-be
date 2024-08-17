package com.example.flight_booking_be.entities;

import com.example.flight_booking_be.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket_code", nullable = false)
    private String ticketCode;

    @Column(nullable = false)
    private String gate;

    @Column(name = "seat_position", nullable = false)
    private String seatPosition;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TicketStatus status;

    @Column(name = "from_airport", nullable = false)
    private String fromAirport;

    @Column(name = "to_airport", nullable = false)
    private String toAirport;

    @ManyToOne()
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

}
