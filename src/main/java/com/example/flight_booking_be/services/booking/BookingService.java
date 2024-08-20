package com.example.flight_booking_be.services.booking;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.example.flight_booking_be.dtos.BookingDTO;
import com.example.flight_booking_be.entities.Booking;
import com.example.flight_booking_be.enums.BookingStatus;
import com.example.flight_booking_be.repositories.BookingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService implements IBookingService{

    private final BookingRepo bookingRepo;

    @Override
    public List<Booking> booking(BookingDTO bookingDTO) {
        List<Booking> bookings = new ArrayList<>();
        String bookingCode = NanoIdUtils.randomNanoId(NanoIdUtils.DEFAULT_NUMBER_GENERATOR, NanoIdUtils.DEFAULT_ALPHABET, 10);
        LocalDateTime now = LocalDateTime.now();
        for(BookingDTO.BasicInformation basicInformation : bookingDTO.getBasicInformation()) {
            Booking booking = new Booking();
            booking.setBookingCode(bookingCode);
            booking.setDate(now);
            booking.setStatus(BookingStatus.PENDING);
            booking.setTotalAmount(basicInformation.getTotalAmount());
            booking.setFirstName(basicInformation.getFirstName());
            booking.setLastName(basicInformation.getLastName());
            booking.setCitizenIdentification(basicInformation.getCitizenIdentification());
            booking.setDateOfBirth(basicInformation.getDateOfBirth());

            bookings.add(booking);
        }

        return bookingRepo.saveAll(bookings);
    }

    @Override
    public List<Booking> getByUserId(Long userId) {
        return bookingRepo.findByUserId(userId);
    }


}
