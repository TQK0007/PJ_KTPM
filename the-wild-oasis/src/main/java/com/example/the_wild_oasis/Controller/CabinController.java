package com.example.the_wild_oasis.Controller;

import com.example.the_wild_oasis.Model.Cabin;
import com.example.the_wild_oasis.Model.Response;
import com.example.the_wild_oasis.Service.CabinService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



import java.util.List;


@RestController
@RequestMapping(path ="/api/v1")
@Slf4j
public class CabinController {

    @Autowired
    private CabinService cabinService;

    @GetMapping(path = "/cabins")
    public ResponseEntity<List<Cabin>> getAll()
    {
        return ResponseEntity.ok(cabinService.getAll());
    }

    @GetMapping(path = "/cabin")
    public ResponseEntity<Response<Cabin>> getByID(@RequestParam(name = "id", required = false) int ID)
    {
        Response<Cabin> response = new Response<>();
        if(cabinService.findByID(ID).isPresent())
        {
            response.setData(cabinService.findByID(ID).get());
            response.setMessage("Search Successful");
            return ResponseEntity.ok(response);
        }
        response.setMessage("Cabin not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    }

    @GetMapping(path = "/cabin/{name}")
    public ResponseEntity<Response<Cabin>> getByName(@PathVariable(name = "name", required = false) String Name)
    {
        Response<Cabin> response = new Response<>();
        if(cabinService.findByName(Name).isPresent())
        {
            response.setData(cabinService.findByName(Name).get());
            response.setMessage("Search Successful");
            return ResponseEntity.ok(response);
        }

        response.setMessage("Cabin not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    // Không được trùng url lẫn phương thức HTTP ví dụ trùng cả GetMapping và url /cabin
    @GetMapping(path = "/cabin/price")
    public ResponseEntity<List<Cabin>> getByRangeRegularPrice(@RequestParam(name = "min", required = false) int min, @RequestParam(name = "max", required = false) int max)
    {
        return ResponseEntity.ok(cabinService.findByRangeRegularPrice(min,max));
    }

    @PostMapping(path = "/cabin/new")
    public ResponseEntity<Response<Cabin>> saveCabin(@RequestBody Cabin cabin)
    {
        try
        {
            cabinService.saveCabin(cabin);
            return ResponseEntity.ok(new Response<>(cabin,"is Saved"));
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Response<>(null,e.getMessage()));
        }
    }

    @PostMapping(path = "/cabin/newList")
    public ResponseEntity<Response<List<Cabin>>> saveAll(@RequestBody List<Cabin> cabins)
    {
        List<Cabin> li = cabinService.saveAll(cabins);
        if(li.isEmpty()) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new Response<>(null,"Error when add a list"));
        return ResponseEntity.ok(new Response<>(li,"is saved"));
    }

    @PutMapping(path = "/cabin/update")
    public ResponseEntity<Response<Cabin>> updateCabin(@RequestBody Cabin cabin)
    {
        try {
            Cabin c = cabinService.updateCabin(cabin);
            return ResponseEntity.ok(new Response<>(cabin,"is Updated"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new Response<>(null,e.getMessage()));
        }

    }

    @PostMapping(value = "/cabin/uploadImg")
    public ResponseEntity<String> uploadImg(@RequestParam("file")MultipartFile file)
    {
        return cabinService.uploadImg(file);
    }

    @PutMapping(path = "/cabin/updateImg")
    public ResponseEntity<String> updateImg(String img, int id)
    {
        if(cabinService.updateImgByID(img,id) ==0) return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Cannot find cabin");
        return ResponseEntity.ok("is Updated");
    }

    @DeleteMapping(path = "/cabin/delete")
    public ResponseEntity<Response<Cabin>> deleteCabin(@RequestParam(name="id") int id)
    {
        try {
            cabinService.deleteCabinByID(id);
            return ResponseEntity.ok(new Response<>(null,"is Deleted"));
        } catch (Exception e) {
            return ResponseEntity.ok(new Response<>(null,e.getMessage()));
        }
    }
}
