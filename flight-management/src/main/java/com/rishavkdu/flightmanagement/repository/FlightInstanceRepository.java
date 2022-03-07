package com.rishavkdu.flightmanagement.repository;

import com.rishavkdu.flightmanagement.entities.FlightInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightInstanceRepository extends JpaRepository<FlightInstance, String> {

    List<FlightInstance> findAll();
    @Query(
            value = "select * from flight_instance natural join route",
            nativeQuery = true
    )
    List<FlightInstance> getAllFlightDetails();
}
