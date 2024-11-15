package com.example.the_wild_oasis.Controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class HomeController {

    private final String BASE_URL="http://localhost:31821";

    @GetMapping("/")
    public String home() {
        return "Hello World1";
    }

    @GetMapping("/image")
    public URI getImage() throws Exception {
        return new URI("http://localhost:31821/Img/cabin-002.jpg");
    }
}
