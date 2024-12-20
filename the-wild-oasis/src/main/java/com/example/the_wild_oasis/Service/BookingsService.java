package com.example.the_wild_oasis.Service;

import com.example.the_wild_oasis.DTO.BookingsDTO;
import com.example.the_wild_oasis.DTO.BookingsUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.example.the_wild_oasis.repository.bookingsRepository;
import com.example.the_wild_oasis.Model.Bookings;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingsService {

    @Value("${the_wild_oasis.pageSize}")
    private int PAGE_SIZE;

    @Autowired
    private bookingsRepository bookingsRepository;

    @Autowired
    private CabinService cabinService;

    @Autowired
    private GuestsService guestsService;

    public List<Bookings> findAll(){
        return bookingsRepository.findAll();
    }

    public Optional<Bookings> findByID(int id)
    {
        return bookingsRepository.findById(id);
    }

    @Transactional
    public Bookings save(Bookings bookings)
    {
//        Không cần sử dụng logic bên dưới Spring boot tự động tìm thông tin đối tượng dựa vào ID ( lưu ý phải cấu hinh trước đó )

//        Cabin c = cabinService.findByID(bookings.getCabin().getCabin_id()).get();
//        Guests g = guestsService.findByID(bookings.getGuests().getGuest_id()).get();
//        bookings.setCabin(c);
//        bookings.setGuests(g);
        return bookingsRepository.save(bookings);
    }

    @Transactional
    public List<Bookings> saveAll(List<Bookings> bookingsList)
    {
        return bookingsRepository.saveAll(bookingsList);
    }

    @Transactional
    public void deleteByID(int id)
    {
        bookingsRepository.deleteById(id);
    }



    public List<BookingsDTO> getAllBookingsDTO()
    {
        Page<Bookings> bookingsPage = bookingsRepository.findAll(PageRequest.of(0, PAGE_SIZE));
        List<Bookings> bookingsList = bookingsPage.getContent();
        List<BookingsDTO> bookingsDTOList = bookingsList.stream().map(b1-> new BookingsDTO(
                        b1.getBookings_id(),
                        b1.getCreateAt(),
                        b1.getStartDate(),
                        b1.getEndDate(),
                        b1.getNumNights(),
                        b1.getNumGuests(),
                        b1.getTotalPrice(),
                        b1.getStatus(),
                        b1.getGuests().getFullName(),
                        b1.getGuests().getEmail(),
                        b1.getCabin().getName()
                ))
                .collect(Collectors.toList());
        return bookingsDTOList;
    }

    public List<BookingsDTO> getAllBookingsDTOByPage(int page)
    {
        Page<Bookings> bookingsPage = bookingsRepository.findAll(PageRequest.of(page - 1, PAGE_SIZE));
        List<Bookings> bookingsList = bookingsPage.getContent();
        List<BookingsDTO> bookingsDTOList = bookingsList.stream().map(b1-> new BookingsDTO(
                        b1.getBookings_id(),
                        b1.getCreateAt(),
                        b1.getStartDate(),
                        b1.getEndDate(),
                        b1.getNumNights(),
                        b1.getNumGuests(),
                        b1.getTotalPrice(),
                        b1.getStatus(),
                        b1.getGuests().getFullName(),
                        b1.getGuests().getEmail(),
                        b1.getCabin().getName()
                ))
                .collect(Collectors.toList());
        return bookingsDTOList;
    }

    public List<BookingsDTO> getAllBookingsDTOByStatusFirst(String status) {
        Page<Bookings> bookingsPage = bookingsRepository.findByStatus(status, PageRequest.of(0, PAGE_SIZE));
        List<Bookings> bookingsList = bookingsPage.getContent();
        List<BookingsDTO> bookingsDTOList = bookingsList.stream().map(b1-> new BookingsDTO(
                        b1.getBookings_id(),
                        b1.getCreateAt(),
                        b1.getStartDate(),
                        b1.getEndDate(),
                        b1.getNumNights(),
                        b1.getNumGuests(),
                        b1.getTotalPrice(),
                        b1.getStatus(),
                        b1.getGuests().getFullName(),
                        b1.getGuests().getEmail(),
                        b1.getCabin().getName()
                ))
                .collect(Collectors.toList());
        return bookingsDTOList;
    }

    public List<BookingsDTO> getAllBookingsDTOByStatus(String status, int page) {
        Page<Bookings> bookingsPage = bookingsRepository.findByStatus(status, PageRequest.of(page-1, PAGE_SIZE));
        List<Bookings> bookingsList = bookingsPage.getContent();
        List<BookingsDTO> bookingsDTOList = bookingsList.stream().map(b1-> new BookingsDTO(
                        b1.getBookings_id(),
                        b1.getCreateAt(),
                        b1.getStartDate(),
                        b1.getEndDate(),
                        b1.getNumNights(),
                        b1.getNumGuests(),
                        b1.getTotalPrice(),
                        b1.getStatus(),
                        b1.getGuests().getFullName(),
                        b1.getGuests().getEmail(),
                        b1.getCabin().getName()
                ))
                .collect(Collectors.toList());
        return bookingsDTOList;
    }


    public List<BookingsDTO> getAllBookingsDTOBySort(String field, String direction, int page) {

        Page<Bookings> bookingsPage = null;
        if(direction.equals("asc")) {
            bookingsPage = bookingsRepository.findAll(PageRequest.of(page-1, PAGE_SIZE, Sort.by(field).ascending()));
        }
        else bookingsPage = bookingsRepository.findAll(PageRequest.of(page-1, PAGE_SIZE, Sort.by(field).descending()));


        List<Bookings> bookingsList = bookingsPage.getContent();
        List<BookingsDTO> bookingsDTOList = bookingsList.stream().map(b1-> new BookingsDTO(
                        b1.getBookings_id(),
                        b1.getCreateAt(),
                        b1.getStartDate(),
                        b1.getEndDate(),
                        b1.getNumNights(),
                        b1.getNumGuests(),
                        b1.getTotalPrice(),
                        b1.getStatus(),
                        b1.getGuests().getFullName(),
                        b1.getGuests().getEmail(),
                        b1.getCabin().getName()
                ))
                .collect(Collectors.toList());
        return bookingsDTOList;
    }


    public List<BookingsDTO> getAllBookingsDTOBySortAndStatus(String field, String direction, String status, int page)
    {
        Page<Bookings> bookingsPage = null;
//        Sort sort = null;
        if(direction.equals("asc")) {
//            sort = Sort.by(field).ascending();
            bookingsPage = bookingsRepository.findByStatus(status, PageRequest.of(page-1, PAGE_SIZE, Sort.by(field).ascending()));
        }
        else
        {
//            sort = Sort.by(field).descending();
            bookingsPage = bookingsRepository.findByStatus(status, PageRequest.of(page-1, PAGE_SIZE, Sort.by(field).descending()));
        }

        List<Bookings> bookingsList = bookingsPage.getContent();
        List<BookingsDTO> bookingsDTOList = bookingsList.stream().map(b1-> new BookingsDTO(
                        b1.getBookings_id(),
                        b1.getCreateAt(),
                        b1.getStartDate(),
                        b1.getEndDate(),
                        b1.getNumNights(),
                        b1.getNumGuests(),
                        b1.getTotalPrice(),
                        b1.getStatus(),
                        b1.getGuests().getFullName(),
                        b1.getGuests().getEmail(),
                        b1.getCabin().getName()
                ))
                .collect(Collectors.toList());
        return bookingsDTOList;
    }

    public long countBookingsDTO() {
        return bookingsRepository.count();
    }

    public long countBookingsDTOByStatus(String status) {
        return bookingsRepository.countByStatus(status);
    }

    public BookingsDTO findBookingDTOByID(int id) throws Exception {
        if(!findByID(id).isPresent()) throw new RuntimeException("Not found Booking");
        Bookings bookings = findByID(id).get();

        return new BookingsDTO(
                bookings.getBookings_id(),
                bookings.getCreateAt(),
                bookings.getStartDate(),
                bookings.getEndDate(),
                bookings.getNumNights(),
                bookings.getNumGuests(),
                bookings.getCabinPrice(),
                bookings.getExtrasPrice(),
                bookings.getTotalPrice(),
                bookings.getStatus(),
                bookings.isHasBreakfast(),
                bookings.getObservations(),
                bookings.isPaid(),
                bookings.getGuests().getFullName(),
                bookings.getGuests().getEmail(),
                bookings.getGuests().getNationality(),
                bookings.getGuests().getNationalID(),
                bookings.getGuests().getCountryFlag(),
                bookings.getCabin().getName()
        );
    }

    @Transactional
    public Bookings updateBookings  (int id, BookingsUpdateDTO bookingsUpdateDTO) throws Exception {
        if(bookingsRepository.findById(id).isEmpty()) throw new RuntimeException("Not found Booking");
        Bookings bookings = findByID(id).get();
        bookingsUpdateDTO.getExtrasPrice().ifPresent(bookings::setExtrasPrice);
        bookingsUpdateDTO.getTotalPrice().ifPresent(bookings::setTotalPrice);
        bookingsUpdateDTO.getStatus().ifPresent(bookings::setStatus);
        bookingsUpdateDTO.getHasBreakfast().ifPresent(bookings::setHasBreakfast);
        bookingsUpdateDTO.getIsPaid().ifPresent(bookings::setPaid);
        return bookingsRepository.save(bookings);
    }

}


