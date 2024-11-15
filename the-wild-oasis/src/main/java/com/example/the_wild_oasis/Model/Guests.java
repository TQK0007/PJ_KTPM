package com.example.the_wild_oasis.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Data
@Entity
@Table(name = "guests")
public class Guests extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guest_id;
    private String fullName;
    private String email;
    private String nationality;
    private String nationalID;
    private String countryFlag;

    @OneToMany(mappedBy = "guests", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,targetEntity = Bookings.class)
    @JsonManagedReference(value = "guests-bookings")
    private List<Bookings> bookings;
}
