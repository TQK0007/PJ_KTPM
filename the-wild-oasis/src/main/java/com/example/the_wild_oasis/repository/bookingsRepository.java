package com.example.the_wild_oasis.repository;

import com.example.the_wild_oasis.Model.Bookings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface bookingsRepository extends JpaRepository<Bookings,Integer> {

    @Query(value = "select b from Bookings b where b.status like :status")
    Page<Bookings> findByStatus(@Param(value = "status" ) String status, Pageable pageable);

    @Query(value = "select count(b) from Bookings b")
    long count();

    @Query(value = "select count(b) from Bookings b where b.status like :status")
    long countByStatus(@Param(value = "status" ) String status);



}
