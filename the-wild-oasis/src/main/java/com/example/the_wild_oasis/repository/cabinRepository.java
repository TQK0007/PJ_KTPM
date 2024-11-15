package com.example.the_wild_oasis.repository;

import com.example.the_wild_oasis.Model.Cabin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface cabinRepository extends JpaRepository<Cabin,Integer> {

    @Query(value = "Select c from Cabin c where c.name = :name", nativeQuery = false)
    Optional<Cabin> findByName(@Param(value = "name" ) String name);

    @Query(value = "select c from Cabin c where c.regularPrice between :min and :max")
    List<Cabin> findByRegularPriceBetween(@Param(value = "min") int min, @Param(value = "max") int max);

    @Modifying
    @Query(value = "Update Cabin c set c.image = :image where c.cabin_id = :id")
    int updateImgByID(@Param(value = "image") String image, @Param(value = "id") int id);

}
