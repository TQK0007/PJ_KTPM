package com.example.the_wild_oasis.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "settings")
public class Settings extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int settings_id;
    private int minBookingsLength;
    private int maxBookingsLength;
    private int maxGuestsPerBookings;
    private double breakfastPrice;
}
