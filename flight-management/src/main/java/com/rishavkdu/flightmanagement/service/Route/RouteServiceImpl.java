package com.rishavkdu.flightmanagement.service.Route;

import com.rishavkdu.flightmanagement.entities.Route;
import com.rishavkdu.flightmanagement.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService{

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public Route saveRoute(Route route) {
        return routeRepository.save(route);
    }
}
