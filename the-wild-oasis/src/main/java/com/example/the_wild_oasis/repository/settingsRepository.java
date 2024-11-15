package com.example.the_wild_oasis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.the_wild_oasis.Model.Settings;
@Repository
public interface settingsRepository extends JpaRepository<Settings, Integer> {

//    @Query(value = "Update Settings s set s.field = :updateValue where s.id = 1")
//    public void updateByField(String field, @Param(value = "updateValue") String updateValue);
}
