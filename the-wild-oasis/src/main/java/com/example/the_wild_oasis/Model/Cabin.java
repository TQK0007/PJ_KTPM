package com.example.the_wild_oasis.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Data
@Entity
@Table(name = "cabin")
public class Cabin extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cabin_id;
    private String name;
    private int maxCapacity;
    private int regularPrice;
    private int discount;
    private String image;

    @JsonIgnore
    private String description;

    @OneToMany(mappedBy = "cabin",cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, targetEntity = Bookings.class)
    @JsonManagedReference(value = "cabin-bookings")

    private List<Bookings> bookings;

}
