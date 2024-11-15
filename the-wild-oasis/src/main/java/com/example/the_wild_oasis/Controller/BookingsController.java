package com.example.the_wild_oasis.Controller;


import com.example.the_wild_oasis.DTO.BookingsDTO;
import com.example.the_wild_oasis.DTO.BookingsUpdateDTO;
import com.example.the_wild_oasis.Model.Bookings;
import com.example.the_wild_oasis.Model.Response;
import com.example.the_wild_oasis.Service.BookingsService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BookingsController {

    @Autowired
    private BookingsService bookingsService;

    @GetMapping("/bookings")
    public ResponseEntity<List<Bookings>> findAll()
    {
        return ResponseEntity.ok(bookingsService.findAll());
    }

    @GetMapping("/booking")
    public ResponseEntity<Response<Bookings>> findByID(@RequestParam(name = "id") int id)
    {
        Optional<Bookings> b = bookingsService.findByID(id);


        if(!b.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new Response<>(null,"Not found bookings"));

        Bookings b2 = b.get();

        return ResponseEntity.ok(new Response<>(b2,"sucessfully"));
    }

    @PostMapping("/booking/new")
    public ResponseEntity<Response<Bookings>> save(@RequestBody Bookings bookings)
    {
        bookingsService.save(bookings);
        return ResponseEntity.ok(new Response<>(bookings,"is saved"));
    }

    @PostMapping("/booking/newList")
    public ResponseEntity<Response<List<Bookings>>> saveAll(@RequestBody List<Bookings> bookingsList)
    {
        List<Bookings> li = bookingsService.saveAll(bookingsList);
        return ResponseEntity.ok(new Response<>(li,"is saved"));
    }


    @DeleteMapping("/deleteBooking")
    public ResponseEntity<Response<String>> deleteByID(@RequestParam(name = "id") int id)
    {
        bookingsService.deleteByID(id);
        return ResponseEntity.ok(new Response<>("is deleted","successfully"));
    }



    @GetMapping("/bookingsDTO")
    public ResponseEntity<List<BookingsDTO>> getAllBookingsDTO()
    {
        return ResponseEntity.ok(bookingsService.getAllBookingsDTO());
    }

    @GetMapping("/bookingsDTOCount")
    public ResponseEntity<Long> countBookingsDTO()
    {
        return ResponseEntity.ok(bookingsService.countBookingsDTO());
    }

    @GetMapping("/bookingsDTOCountByStatus")
    public ResponseEntity<Long> countBookingsDTOByStatus(@RequestParam(name = "status",required = false) String status)
    {
        return ResponseEntity.ok(bookingsService.countBookingsDTOByStatus(status));
    }

    @GetMapping("/bookingsDTOPerPage")
    public ResponseEntity<List<BookingsDTO>> getAllBookingsDTOByPage(@RequestParam(name = "page",required = false, defaultValue = "1") int page)
    {
        return ResponseEntity.ok(bookingsService.getAllBookingsDTOByPage(page));
    }

    @GetMapping("/bookingsDTOStatusFirst")
    public ResponseEntity<List<BookingsDTO>> getAllBookingsDTOByStatusFirst(@RequestParam(name = "status",required = false) String status)
    {
        return ResponseEntity.ok(bookingsService.getAllBookingsDTOByStatusFirst(status));
    }

    @GetMapping("/bookingsDTOStatus")
    public ResponseEntity<List<BookingsDTO>> getAllBookingsDTOByStatus(@RequestParam(name = "status",required = false) String status,
                                                                       @RequestParam(name = "page",required = false, defaultValue = "1" ) int page)
    {
        return ResponseEntity.ok(bookingsService.getAllBookingsDTOByStatus(status,page));
    }

    @GetMapping("/bookingsDTOSort")
    public ResponseEntity<List<BookingsDTO>> getAllBookingsDTOBySort(@RequestParam(name = "sortBy",required = false) String sortBy,
                                                                     @RequestParam(name = "page",required = false, defaultValue = "1" ) int page)
    {
        String [] arr = sortBy.split("-");
        return ResponseEntity.ok(bookingsService.getAllBookingsDTOBySort(arr[0],arr[1],page));
    }

    @GetMapping("/bookingsDTOSortAndStatus")
    public ResponseEntity<List<BookingsDTO>> getAllBookingsDTOBySortAndStatus(@RequestParam(name = "sortBy",required = false) String sortBy,
                                                                             @RequestParam(name = "status",required = false) String status,
                                                                             @RequestParam(name = "page",required = false, defaultValue = "1" ) int page)
    {
        String [] arr = sortBy.split("-");
        return ResponseEntity.ok(bookingsService.getAllBookingsDTOBySortAndStatus(arr[0],arr[1],status,page));
    }

    @GetMapping("/bookingsDTOById")
    public ResponseEntity<Response<BookingsDTO>> findBookingDTOByID(@RequestParam(name = "id",required = false) int id)
    {
        try {
            return ResponseEntity.ok(new Response<>(bookingsService.findBookingDTOByID(id),"successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>(null,e.getMessage()));
        }
    }


    @PatchMapping("/updateBooking")
    public ResponseEntity<Response<Bookings>> updateBookings(@RequestParam(name = "id") int id, @RequestBody BookingsUpdateDTO bookingsUpdateDTO)
    {
        try {
            return ResponseEntity.ok(new Response<>(bookingsService.updateBookings(id,bookingsUpdateDTO),"successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>(null,e.getMessage()));
        }
    }
}
