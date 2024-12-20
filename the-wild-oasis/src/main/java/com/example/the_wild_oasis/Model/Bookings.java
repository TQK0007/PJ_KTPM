package com.example.the_wild_oasis.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "bookings")
public class Bookings extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookings_id;
    private int numNights;
    private int numGuests;
    private double cabinPrice;
    private double extrasPrice;
    private double totalPrice;
    private String status;
    private boolean hasBreakfast;
    private boolean isPaid;
    private String observations;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cabin_id", referencedColumnName = "cabin_id")
    @JsonBackReference(value = "cabin-bookings")
    private Cabin cabin;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "guest_id", referencedColumnName = "guest_id")
    @JsonBackReference(value = "guests-bookings")
    private Guests guests;
}
