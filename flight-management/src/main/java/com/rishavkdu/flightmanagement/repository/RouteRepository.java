package com.rishavkdu.flightmanagement.repository;

import com.rishavkdu.flightmanagement.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, String> {
}
