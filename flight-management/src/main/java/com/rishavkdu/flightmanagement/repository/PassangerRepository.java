package com.rishavkdu.flightmanagement.repository;

import com.rishavkdu.flightmanagement.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassangerRepository extends JpaRepository<Passenger, Long> {

    @Query(
            value = "select * from passenger\n" +
                    "natural join flight_instance\n" +
                    "where airplane_id = :airplaneId \n",
            nativeQuery = true
    )
    List<Passenger> getAllPassangersByAirplaneId(@Param("airplaneId") String airplaneId);
}
