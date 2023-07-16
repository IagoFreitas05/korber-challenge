package com.challenge.challenge.repositories;

import com.challenge.challenge.entities.Trip;
import com.challenge.challenge.entities.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
    Page<Trip> findByType(Type type, Pageable pageable);
}
