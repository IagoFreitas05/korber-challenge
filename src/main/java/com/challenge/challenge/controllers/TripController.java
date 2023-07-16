package com.challenge.challenge.controllers;

import com.challenge.challenge.entities.Trip;
import com.challenge.challenge.entities.Type;
import com.challenge.challenge.services.TripService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/trips")
public class TripController {
    TripService tripService;
    @Autowired
    public TripController(TripService tripService){
        this.tripService = tripService;
    }

    @PostMapping("/move/yellow")
    public ResponseEntity<HttpStatus> moveYellow() throws IOException, CsvValidationException {
        this.tripService.saveCSVData(Type.YELLOW);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/move/green")
    public ResponseEntity<HttpStatus> moveGreen() throws IOException, CsvValidationException {
        this.tripService.saveCSVData(Type.GREEN);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<Page<Trip>> index(Pageable pageable){
        return ResponseEntity.ok(this.tripService.index(pageable));
    }

    @GetMapping("list-yellow")
    public ResponseEntity<Page<Trip>> getYellowTrips(Pageable pageable){
        return ResponseEntity.ok(this.tripService.findByType( pageable, Type.YELLOW));
    }

    @GetMapping("list-green")
    public ResponseEntity<Page<Trip>> getGreenTrips(Pageable pageable){
        return ResponseEntity.ok(this.tripService.findByType( pageable, Type.GREEN));
    }
}
