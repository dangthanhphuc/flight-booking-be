package com.example.flight_booking_be.responses;

import com.example.flight_booking_be.entities.Plane;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaneResponse {

    private String name;

    private String type;

    @JsonProperty("plane_code")
    private String planeCode;

    @JsonProperty("seat_capacity")
    private int seatCapacity;

    public static PlaneResponse fromPlane(Plane plane) {
        return PlaneResponse.builder()
                .name(plane.getName())
                .planeCode(plane.getPlaneCode())
                .seatCapacity(plane.getSeatCapacity())
                .build();
    }

}
