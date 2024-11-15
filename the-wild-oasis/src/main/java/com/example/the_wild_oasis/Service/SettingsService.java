package com.example.the_wild_oasis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.the_wild_oasis.repository.settingsRepository;
import com.example.the_wild_oasis.Model.Settings;

import java.util.List;
import java.util.Optional;

@Service
public class SettingsService {

    @Autowired
    private settingsRepository settingsRepository;

    public List<Settings> findAll(){
        return settingsRepository.findAll();
    }

    public Optional<Settings> findByID(int id){
        return settingsRepository.findById(id);
    }

    public Settings save(Settings settings){
        return settingsRepository.save(settings);
    }

    public List<Settings> saveAll(List<Settings> settings){
        return settingsRepository.saveAll(settings);
    }
    public Settings updateByID(Settings settings) throws Exception{
        if(settingsRepository.findById(settings.getSettings_id()).isEmpty()) throw new RuntimeException("Not found Settings");
        if(settings.getMinBookingsLength() <= 0) throw new RuntimeException("Min Bookings Length must be greater than 0");
        if(settings.getMaxBookingsLength() <= settings.getMinBookingsLength()) throw new RuntimeException("Max Bookings Length must be greater than Min Bookings Length");
        if(settings.getMaxGuestsPerBookings() <=0) throw new RuntimeException("Max Guests Per Bookings must be greater than 0");
        if(settings.getBreakfastPrice() <=0 ) throw new RuntimeException("Breakfast Price must be greater than 0");
        return settingsRepository.save(settings);
    }




    public void deleteByID(int id){
        settingsRepository.deleteById(id);
    }
}
