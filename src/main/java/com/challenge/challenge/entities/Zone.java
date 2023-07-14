package com.challenge.challenge.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_zones")
public class Zone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long locationId;
    public String borough;
    public String zone;
}
