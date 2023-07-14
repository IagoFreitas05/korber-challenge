package com.challenge.challenge.repositories;

import com.challenge.challenge.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
