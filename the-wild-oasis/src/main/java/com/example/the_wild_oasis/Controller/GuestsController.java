package com.example.the_wild_oasis.Controller;

import com.example.the_wild_oasis.Model.Cabin;
import com.example.the_wild_oasis.Model.Guests;
import com.example.the_wild_oasis.Model.Response;
import com.example.the_wild_oasis.Service.GuestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GuestsController {

    @Autowired
    private GuestsService guestsService;

    @GetMapping(path = "/guests")
    public List<Guests> getAll()
    {
        return guestsService.findAll();
    }

    @PostMapping("/guests/new")
    public ResponseEntity<Response<Guests>> save(@RequestBody Guests guests)
    {
        try
        {
            Guests g = guestsService.save(guests);
            Response<Guests> g1 = new Response<>(g,"is saved");
            return ResponseEntity.ok(g1);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Response<>(null,e.getMessage()));
        }
    }

    @PostMapping("/guests/newList")
    public ResponseEntity<Response<List<Guests>>> saveAll(@RequestBody List<Guests> guests)
    {
        List<Guests> li = guestsService.saveAll(guests);
        if(li.isEmpty()) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new Response<>(null,"not save"));
        return ResponseEntity.ok(new Response<>(li,"is saved"));
    }

    @PutMapping(path = "/guests/update")
    public ResponseEntity<Response<Guests>> updateGuest(@RequestBody Guests guests)
    {
        try
        {
            Guests g = guestsService.updateByID(guests);
            return ResponseEntity.ok(new Response<>(g,"is updated"));
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND   ).body(new Response<>(null,e.getMessage()));
        }
    }

    @DeleteMapping(path = "/guests/delete")
    public ResponseEntity<Response<Guests>> deleteGuest(@RequestParam(name = "id") int id)
    {
        try
        {
            guestsService.deleteById(id);
            return ResponseEntity.ok(new Response<>(null,"is deleted"));
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>(null,e.getMessage()));
        }

    }
}
