package com.example.the_wild_oasis.Controller;

import com.example.the_wild_oasis.Model.Response;
import com.example.the_wild_oasis.Service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.the_wild_oasis.Model.Settings;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class SettingsController {

    @Autowired
    private SettingsService settingsService;


    @GetMapping("/setting/find")
    public Settings findSetting()
    {
        return settingsService.findByID(1).get();
    }

    @GetMapping("/settings")
    public ResponseEntity<List<Settings>> findAll(){
        return ResponseEntity.ok(settingsService.findAll());
    }

    @GetMapping("/setting")
    public ResponseEntity<Response<Settings>> findByID(@RequestParam(name = "id" ) int id){
        Optional<Settings> settings = settingsService.findByID(id);
        if(!settings.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response<>(null,"Not found Settings"));
        }
        return ResponseEntity.ok(new Response<>(settings.get(),"sucessfully"));
    }

    @PostMapping("/setting/new")
    public ResponseEntity<Response<Settings>> save(@RequestBody Settings settings){
        return ResponseEntity.ok(new Response<>(settingsService.save(settings),"is saved"));

    }

    @PostMapping("/setting/newList")
    public ResponseEntity<Response<List<Settings>>> saveAll(@RequestBody List<Settings> settingsList){
        return ResponseEntity.ok(new Response<>(settingsService.saveAll(settingsList),"is saved"));
    }

    @PutMapping("/setting/update")
    public ResponseEntity<Response<Settings>> updateByID(@RequestBody Settings settings){
        try {
            return ResponseEntity.ok(new Response<>(settingsService.updateByID(settings),"is updated"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<>(null,e.getMessage()));
        }
    }

    @DeleteMapping("/setting/delete")
    public ResponseEntity<Response<String>> deleteByID(@RequestParam(name = "id") int id){
        settingsService.deleteByID(id);
        return ResponseEntity.ok(new Response<>("is deleted","successfully"));
    }
}
