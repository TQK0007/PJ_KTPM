package com.example.the_wild_oasis.repository;

import com.example.the_wild_oasis.Model.Guests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface guestsRepository extends JpaRepository<Guests, Integer> {
}
