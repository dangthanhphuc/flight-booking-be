package com.example.flight_booking_be.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seat_classes")
public class SeatClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "total_weight", nullable = false)
    private int totalWeight;

    @Column(name = "priority_checkin", nullable = false)
    private int priorityCheckin;

    @Column(name = "selected_seat", nullable = false)
    private int selectedSeat;
}
