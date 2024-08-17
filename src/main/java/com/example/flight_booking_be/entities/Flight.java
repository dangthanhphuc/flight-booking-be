package com.example.flight_booking_be.entities;

import com.example.flight_booking_be.enums.FlightStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String flightNumber;

    @Column(name = "departure_date_time", nullable = false)
    private LocalDateTime departureDateTime;

    @Column(name = "arrival_date_time", nullable = false)
    private LocalDateTime arrivalDateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private FlightStatus status;

    @Column(name = "economy_class", nullable = false)
    private int economyClass;

    @Column(name = "business_class", nullable = false)
    private int businessClass;

    @Column(name = "special_class", nullable = false)
    private int specialClass;

    @Column(name = "economy_price", nullable = false)
    private int economyPrice;

    @Column(name = "business_price", nullable = false)
    private int businessPrice;

    @Column(name = "special_price", nullable = false)
    private int specialPrice;

    @ManyToOne()
    @JoinColumn(name = "plane_id", nullable = false)
    private Plane plane;

    @ManyToOne()
    @JoinColumn(name = "from_airport_id", nullable = false)
    private Airport fromAirport;

    @ManyToOne()
    @JoinColumn(name = "to_airport_id", nullable = false)
    private Airport toAirport;

}
