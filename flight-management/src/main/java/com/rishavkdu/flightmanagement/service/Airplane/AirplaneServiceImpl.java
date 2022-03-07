package com.rishavkdu.flightmanagement.service.Airplane;

import com.rishavkdu.flightmanagement.entities.Airplane;
import com.rishavkdu.flightmanagement.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirplaneServiceImpl implements AirplaneService{

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Override
    public Airplane getById(String airplaneId) {
        return airplaneRepository.findById(airplaneId).get();
    }
}
