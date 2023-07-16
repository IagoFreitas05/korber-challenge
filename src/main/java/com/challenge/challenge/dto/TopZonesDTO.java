package com.challenge.challenge.dto;



public class TopZonesDTO {
    public String zone;
    public Long puTotal;
    public Long doTotal;

    public TopZonesDTO(String zone, Long puTotal, Long doTotal) {
        this.zone = zone;
        this.puTotal = puTotal;
        this.doTotal = doTotal;
    }
}
