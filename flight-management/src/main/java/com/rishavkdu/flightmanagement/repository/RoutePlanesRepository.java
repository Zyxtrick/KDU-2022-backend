package com.rishavkdu.flightmanagement.repository;

import com.rishavkdu.flightmanagement.entities.RoutePlanes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutePlanesRepository extends JpaRepository<RoutePlanes, String> {
}
