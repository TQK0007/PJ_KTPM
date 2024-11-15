package com.example.the_wild_oasis.Service;

import com.example.the_wild_oasis.Model.Guests;
import com.example.the_wild_oasis.repository.guestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GuestsService {

    @Autowired
    private guestsRepository guestsRepository;

    public List<Guests> findAll()
    {
        return guestsRepository.findAll();
    }

    public Optional<Guests> findByID(int id)
    {
        return guestsRepository.findById(id);
    }


    @Transactional
    public Guests save(Guests guest) throws Exception
    {
        if(findByID(guest.getGuest_id()).isPresent()) throw new RuntimeException("guests_id already exists");
        return guestsRepository.save(guest);
    }

    @Transactional
    public List<Guests> saveAll(List<Guests> guests)
    {
        if(guestsRepository.saveAll(guests).isEmpty()) return List.of();
        return guestsRepository.saveAll(guests);
    }

    @Transactional
    public Guests updateByID(Guests guests) throws Exception
    {
        if(!findByID(guests.getGuest_id()).isPresent()) throw  new RuntimeException("Not found Guest");
        return guestsRepository.save(guests);
    }

    @Transactional
    public void deleteById(int id) throws Exception
    {
        if(!findByID(id).isPresent()) throw  new RuntimeException("Not found Guest");
        guestsRepository.deleteById(id);
    }

}
