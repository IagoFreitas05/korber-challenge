package com.challenge.challenge.services;

import com.challenge.challenge.entities.Trip;
import com.challenge.challenge.entities.Type;
import com.challenge.challenge.repositories.TripRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class TripService {
    private final ResourceLoader resourceLoader;
    private Resource csvYellowresource;
    private Resource csvGreenResource;

    private final TripRepository tripRepository;

    @Autowired
    public TripService(ResourceLoader resourceLoader, TripRepository tripRepository) {
        this.resourceLoader = resourceLoader;
        this.tripRepository = tripRepository;
    }

    @PostConstruct
    public void init() {
        csvYellowresource = resourceLoader.getResource("classpath:yellow_trip.csv");
        csvGreenResource = resourceLoader.getResource("classpath:green_trip.csv");
    }

    @Transactional
    public void saveCSVData(Type type) throws IOException, CsvValidationException {
        CSVReader reader = new CSVReaderBuilder(new InputStreamReader(type == Type.YELLOW ? csvYellowresource.getInputStream() : csvGreenResource.getInputStream())).build();
        String[] nextLine;
        int count = 0;
        while ((nextLine = reader.readNext()) != null) {
            count++;
            Trip trip = new Trip();
            trip.setType(type);
            trip.setPickUpId(Long.valueOf(nextLine[0]));
            trip.setPickUpDatetime(String.valueOf(nextLine[1]));
            trip.setDropOffDatetime(String.valueOf(nextLine[2]));
            trip.setDropOffId(Long.valueOf(nextLine[4]));
            this.tripRepository.save(trip);
            System.out.println(count);
        }
    }

    public Page<Trip> index(Pageable pageable){
        return this.tripRepository.findAll(pageable);
    }

    public Page<Trip> findByType(Pageable pageable, Type type){
        return this.tripRepository.findByType(type,pageable);
    }
}
