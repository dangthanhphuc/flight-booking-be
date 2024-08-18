package com.example.flight_booking_be.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "planes")
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "plane_code", nullable = false)
    private String planeCode;

    @Column(name = "seat_capacity", nullable = false)
    private int seatCapacity;

}
