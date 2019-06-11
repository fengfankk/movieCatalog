package com.example.movieCatalogService.controller;

import com.example.pojo.Rating;
import com.example.pojo.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/catalog")
public class movieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public List<Rating> getMovie(@PathVariable("userId") String userId){
        UserRating userRating = restTemplate.getForObject("http://rating-service/ratingsData/user/" + userId, UserRating.class);

        return userRating.getRatings();
    }
}
