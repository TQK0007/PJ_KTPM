package com.example.the_wild_oasis.Service;

import com.example.the_wild_oasis.DTO.BookingsUpdateDTO;
import com.example.the_wild_oasis.Model.Bookings;
import com.example.the_wild_oasis.Model.Cabin;
import com.example.the_wild_oasis.Model.Guests;
import com.example.the_wild_oasis.repository.bookingsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class updateBookingsTest {

    @Autowired
    private BookingsService bookingsService;

    @MockBean
    private bookingsRepository bookingsRepository;

    Bookings createBooking()
    {
        Bookings booking = new Bookings();
        booking.setBookings_id(0);
        booking.setCabinPrice(4200);
        booking.setCreateAt(LocalDateTime.parse("2024-10-30T10:34:53.656"));
        booking.setEndDate(LocalDateTime.parse("2024-11-22T00:00:00.000"));
        booking.setExtrasPrice(0);
        booking.setHasBreakfast(false);
        booking.setPaid(false);
        booking.setNumGuests(7);
        booking.setNumNights(3);
        booking.setObservations("");
        booking.setStartDate(LocalDateTime.parse("2024-11-19T00:00:00.000"));
        booking.setStatus("unconfirmed");
        booking.setTotalPrice(4200);

        Cabin cabin = new Cabin();
        cabin.setCabin_id(8);
        booking.setCabin(cabin);

        Guests guests = new Guests();
        guests.setGuest_id(24);
        booking.setGuests(guests);
        return  booking;
    }

    @Test
    void shouldThrowExceptionWhenBookingNotFound()
    {
        int id = 30;
        BookingsUpdateDTO bookingsUpdateDTO = new BookingsUpdateDTO();
        bookingsUpdateDTO.setStatus(Optional.of("check-in"));
        bookingsUpdateDTO.setIsPaid(Optional.of(true));
        when(bookingsRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class,()->bookingsService.updateBookings(id, bookingsUpdateDTO));
    }

    @Test
    void shouldThrowExceptionWhenBookingNotFoundAndAllFieldsPresent()
    {
        int id = 30;
        BookingsUpdateDTO bookingsUpdateDTO = new BookingsUpdateDTO();
        bookingsUpdateDTO.setStatus(Optional.of("check-in"));
        bookingsUpdateDTO.setIsPaid(Optional.of(true));
        bookingsUpdateDTO.setExtrasPrice(Optional.of(450.0));
        bookingsUpdateDTO.setTotalPrice(Optional.of(4650.0));
        bookingsUpdateDTO.setHasBreakfast(Optional.of(true));

        when(bookingsRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class,()->bookingsService.updateBookings(id, bookingsUpdateDTO));
    }

    @Test
    void shouldUpdateStatusAndisPaid() throws Exception {
        int id = 29;
        Bookings bookings = createBooking();
        BookingsUpdateDTO bookingsUpdateDTO = new BookingsUpdateDTO();
        bookingsUpdateDTO.setStatus(Optional.of("check-in"));
        bookingsUpdateDTO.setIsPaid(Optional.of(true));

        when(bookingsRepository.findById(id)).thenReturn(Optional.of(bookings));
        when(bookingsRepository.save(bookings)).thenReturn(bookings);

        Bookings updatedBookings = bookingsService.updateBookings(id, bookingsUpdateDTO);
        assertEquals("check-in",updatedBookings.getStatus());
        assertTrue(updatedBookings.isPaid());
    }

    @Test
    void shouldUpdateAllFields() throws Exception {
        int id = 29;
        Bookings bookings = createBooking();
        BookingsUpdateDTO bookingsUpdateDTO = new BookingsUpdateDTO();
        bookingsUpdateDTO.setStatus(Optional.of("check-in"));
        bookingsUpdateDTO.setIsPaid(Optional.of(true));
        bookingsUpdateDTO.setExtrasPrice(Optional.of(450.0));
        bookingsUpdateDTO.setTotalPrice(Optional.of(4650.0));
        bookingsUpdateDTO.setHasBreakfast(Optional.of(true));

        when(bookingsRepository.findById(id)).thenReturn(Optional.of(bookings));
        when(bookingsRepository.save(bookings)).thenReturn(bookings);

        Bookings updatedBookings = bookingsService.updateBookings(id, bookingsUpdateDTO);
        assertEquals("check-in",updatedBookings.getStatus());
        assertTrue(updatedBookings.isPaid());
        assertEquals(450.0,updatedBookings.getExtrasPrice());
        assertEquals(4650.0,updatedBookings.getTotalPrice());
        assertTrue(updatedBookings.isHasBreakfast());
    }
}