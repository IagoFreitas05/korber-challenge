package com.challenge.challenge.dto;

public class ZoneTripsDTO {
    public ZoneTripsDTO(String zone, Long pickUp, Long dropOff, String date) {
        this.zone = zone;
        this.pickUp = pickUp;
        this.dropOff = dropOff;
        this.date = date;
    }

    public String zone;
    public String date;
    public Long pickUp;
    public Long dropOff;


}
