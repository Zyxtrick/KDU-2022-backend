package com.rishavkdu.flightmanagement.repository;

import com.rishavkdu.flightmanagement.entities.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, String> {
}
