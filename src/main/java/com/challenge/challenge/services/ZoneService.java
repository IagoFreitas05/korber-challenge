package com.challenge.challenge.services;

import com.challenge.challenge.dto.TopZonesDTO;
import com.challenge.challenge.dto.ZoneTripsDTO;
import com.challenge.challenge.entities.Zone;
import com.challenge.challenge.repositories.ZoneRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class ZoneService {
    @Autowired
    private ZoneRepository zoneRepository;
    private Resource csvResource;
    private final ResourceLoader resourceLoader;
    public ZoneService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    @PostConstruct
    public void init() {
        csvResource = resourceLoader.getResource("classpath:zones.csv");
    }

    public void saveCSVData() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(csvResource.getInputStream()))) {
            CsvToBean<Zone> csvToBean = new CsvToBeanBuilder<Zone>(reader)
                    .withType(Zone.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Zone> records = csvToBean.parse();

            zoneRepository.saveAll(records);
        }
    }

    public Page<Zone> index(Pageable pageable){
      return  this.zoneRepository.findAll(pageable);
    }

    public List<TopZonesDTO> topZones(Pageable pageable, String orderByParam){
        return this.zoneRepository.findTopZonesWithMostPickUpAndDropOff(pageable, orderByParam);
    }

    public ZoneTripsDTO zoneTripsDTOS(Long locationId, String  date){
        return this.zoneRepository.findZoneTripsDTO(locationId, date);
    }
}

