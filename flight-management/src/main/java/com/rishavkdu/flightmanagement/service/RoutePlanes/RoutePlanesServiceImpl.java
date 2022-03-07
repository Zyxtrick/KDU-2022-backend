package com.rishavkdu.flightmanagement.service.RoutePlanes;

import com.rishavkdu.flightmanagement.entities.RoutePlanes;
import com.rishavkdu.flightmanagement.repository.RoutePlanesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoutePlanesServiceImpl implements RoutePlanesService{

    @Autowired
    private RoutePlanesRepository routePlanesRepository;

    @Override
    public RoutePlanes getById(String routeId) {
        return routePlanesRepository.findById(routeId).get();
    }
}
