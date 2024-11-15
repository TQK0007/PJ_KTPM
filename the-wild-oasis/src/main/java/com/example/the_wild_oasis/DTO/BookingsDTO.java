package com.example.the_wild_oasis.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingsDTO {
    private int id;
    private LocalDateTime createdAt;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int numNights;
    private int numGuests;

    private double cabinPrice;
    private double extrasPrice;

    private double totalPrice;
    private String status;

    private boolean hasBreakfast;
    private String observations;
    private boolean isPaid;

    private String guestName;
    private String email;
    private String nationality;
    private String nationalID;
    private String countryFlag;
    private String cabinName;


    public BookingsDTO(int id, LocalDateTime createdAt, LocalDateTime startDate, LocalDateTime endDate, int numNights, int numGuests, double totalPrice, String status, String guestName, String email, String cabinName) {
        this.id = id;
        this.createdAt = createdAt;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numNights = numNights;
        this.numGuests = numGuests;
        this.totalPrice = totalPrice;
        this.status = status;
        this.guestName = guestName;
        this.email = email;
        this.cabinName = cabinName;
    }


}
