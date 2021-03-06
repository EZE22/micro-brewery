package com.example.beerservice.controller;

import com.example.beerservice.entity.Beer;
import com.example.beerservice.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class BeerController {

    private final BeerRepository repository;

    @Autowired
    public BeerController(BeerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String getBeerHome() {
        return "Welcome from the Beer Service!";
    }

    @GetMapping("/all-beers")
    public List<Beer> getBeers() {
        return repository.findAll();
    }

    @GetMapping("/beer-id/{id}")
    public Beer getById(@PathVariable("id") BigInteger id) {
        return repository.findBeerByBeerid(id);
    }

    @GetMapping("/{name}")
    public Beer getBeerByName(@PathVariable("name") String name) {
        return repository.findAllByBeername(name);
    }

    @PostMapping("/create")
    public void saveBeer(@RequestBody Beer course) {
        repository.save(course);
    }

    @DeleteMapping("/delete-beer/{id}")
    public void deleteBeer(@PathVariable("id") BigInteger id) {
        repository.deleteById(id);
    }
}

