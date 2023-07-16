package com.challenge.challenge.controllers;

import com.challenge.challenge.dto.TopZonesDTO;
import com.challenge.challenge.dto.ZoneTripsDTO;
import com.challenge.challenge.entities.Zone;
import com.challenge.challenge.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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

    @GetMapping( "/top-zones")
    public ResponseEntity<List<TopZonesDTO>> topZones( @RequestParam(value = "orderBy", defaultValue = "pickup") String orderByParam){
        Pageable pageable = PageRequest.of(0, 5);
        return  ResponseEntity.ok(this.zoneService.topZones(pageable, orderByParam));
    }

    @GetMapping("/zone-trips")
    public ResponseEntity<ZoneTripsDTO> zoneTrips(
            @RequestParam(value = "locationId", defaultValue = "") Long locationId,
            @RequestParam(value = "date", defaultValue = "") String date){
        return ResponseEntity.ok(this.zoneService.zoneTripsDTOS(locationId, date));
    }
}
