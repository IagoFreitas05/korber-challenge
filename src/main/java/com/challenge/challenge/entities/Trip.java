package com.challenge.challenge.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_trip")
public class Trip implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long pickUpId;
    public LocalDateTime pickUpAddress;
    public LocalDateTime dropOffAddress;
    public Long dropOffId;
    public Type type;
}
