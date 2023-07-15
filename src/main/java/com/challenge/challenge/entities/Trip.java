package com.challenge.challenge.entities;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "tb_trip")
public class Trip {
    @CsvBindByName(column = "pickUpId")
    public Long pickUpId;

    @CsvBindByName(column = "pickUpDatetime")
    public LocalDateTime pickUpDatetime;

    @CsvBindByName(column = "dropOffDatetime")
    public LocalDateTime dropOffDatetime;

    @CsvBindByName(column = "dropOffId")
    public Long dropOffId;

    @CsvBindByName(column = "type")
    public Type type;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setPickUpDatetime(String pickUpAddress) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.pickUpDatetime = LocalDateTime.parse(pickUpAddress, formatter);
    }

    public void setDropOffDatetime(String dropOffAddress) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.dropOffDatetime = LocalDateTime.parse(dropOffAddress, formatter);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPickUpId() {
        return pickUpId;
    }

    public void setPickUpId(Long pickUpId) {
        this.pickUpId = pickUpId;
    }

    public Long getDropOffId() {
        return dropOffId;
    }

    public void setDropOffId(Long dropOffId) {
        this.dropOffId = dropOffId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }
}
