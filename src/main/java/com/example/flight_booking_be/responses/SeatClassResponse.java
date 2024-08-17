package com.example.flight_booking_be.responses;

import com.example.flight_booking_be.entities.SeatClass;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeatClassResponse {
    private String name;

    @JsonProperty("total_weight")
    private int totalWeight;

    @JsonProperty("priority_checkin")
    private int priorityCheckin;

    @JsonProperty("select_seat")
    private int selectedSeat;

    public static SeatClassResponse fromSeatClass(SeatClass seatClass) {
        return SeatClassResponse.builder()
                .name(seatClass.getName())
                .totalWeight(seatClass.getTotalWeight())
                .priorityCheckin(seatClass.getPriorityCheckin())
                .selectedSeat(seatClass.getSelectedSeat())
                .build();
    }

}
