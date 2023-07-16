package com.challenge.challenge.repositories;

import com.challenge.challenge.dto.TopZonesDTO;
import com.challenge.challenge.dto.ZoneTripsDTO;
import com.challenge.challenge.entities.Zone;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ZoneRepository extends JpaRepository<Zone, Long> {
    @Query("SELECT NEW com.challenge.challenge.dto.TopZonesDTO(z.zone, \n" +
            "    (SELECT COUNT(t.dropOffId) FROM Trip t WHERE t.dropOffId = z.locationId),\n" +
            "    (SELECT COUNT(t.pickUpId) FROM Trip t WHERE t.pickUpId = z.locationId))\n" +
            "FROM Zone z\n" +
            "ORDER BY \n" +
            "    CASE :orderByParam\n" +
            "        WHEN 'dropoff' THEN (SELECT COUNT(t.dropOffId) FROM Trip t WHERE t.dropOffId = z.locationId)\n" +
            "        WHEN 'pickup' THEN (SELECT COUNT(t.pickUpId) FROM Trip t WHERE t.pickUpId = z.locationId)\n" +
            "    END DESC")
    List<TopZonesDTO> findTopZonesWithMostPickUpAndDropOff(Pageable pageable,@Param("orderByParam")  String orderByParam);
    @Query("SELECT " +
            "NEW com.challenge.challenge.dto.ZoneTripsDTO(z.zone, SUM( t.pickUpId), SUM( t.dropOffId), CAST(:dateParam AS string) ) " +
            "FROM Zone z " +
            "JOIN Trip t ON z.locationId = t.pickUpId OR z.locationId = t.dropOffId " +
            "WHERE FUNCTION('DATE', t.pickUpDatetime) = FUNCTION('DATE', :dateParam) " +
            "    AND z.locationId = :locationIdParam " +
            "GROUP BY z.zone")
    ZoneTripsDTO findZoneTripsDTO(@Param("locationIdParam") Long locationIdParam, @Param("dateParam") String dateParam);
}