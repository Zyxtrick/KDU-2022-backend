package com.rishavkdu.flightmanagement.repository;

import com.rishavkdu.flightmanagement.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {

}
