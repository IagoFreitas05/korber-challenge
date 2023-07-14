package com.challenge.challenge.controllers;

import com.challenge.challenge.entities.Zone;
import com.challenge.challenge.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/zones")
public class ZoneController {
    ZoneService zoneService;

    @Autowired
    public ZoneController(ZoneService zoneService){
        this.zoneService = zoneService;
    }

    @PostMapping("/move")
    public ResponseEntity<HttpStatus> move() throws IOException {
        this.zoneService.saveCSVData();

        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<Page<Zone>> index(Pageable pageable){
        return ResponseEntity.ok(this.zoneService.index(pageable));
    }
}
