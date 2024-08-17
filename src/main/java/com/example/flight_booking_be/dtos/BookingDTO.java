package com.example.flight_booking_be.dtos;

import com.example.flight_booking_be.enums.FlightStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

    @JsonProperty("basic_information")
    private List<BasicInformation> basicInformation;

    @JsonProperty("flight_id")
    private Long flightId;

    @JsonProperty("passenger_id")
    private Long passengerId;

    @JsonProperty("seat_class_id")
    private Long seatClassId;

    @Getter
    public static class BasicInformation {

        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        @JsonProperty("date_of_birth")
        private LocalDate dateOfBirth;

        @JsonProperty("citizen_identification")
        private String citizenIdentification;

        @JsonProperty("total_amount")
        private float totalAmount;
    }
}


