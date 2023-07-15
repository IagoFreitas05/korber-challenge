package com.challenge.challenge.controllers;

import com.challenge.challenge.entities.Type;
import com.challenge.challenge.services.TripService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

   /* @GetMapping()
    public ResponseEntity<Page<Trip>> index(Pageable pageable){
        return ResponseEntity.ok(this.tripService.index(pageable));
    }*/
}
