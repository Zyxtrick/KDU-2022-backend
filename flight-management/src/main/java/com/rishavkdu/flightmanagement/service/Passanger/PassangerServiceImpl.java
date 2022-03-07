package com.rishavkdu.flightmanagement.service.Passanger;

import com.rishavkdu.flightmanagement.entities.Passenger;
import com.rishavkdu.flightmanagement.repository.PassangerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassangerServiceImpl implements PassangerService{

    @Autowired
    private PassangerRepository passangerRepository;

    @Override
    public Passenger savePassenger(Passenger passenger) {
        return passangerRepository.save(passenger);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passangerRepository.findAll();
    }

    @Override
    public List<Passenger> getAllPassangersByAirPlaneId(String airplaneId) {
        return passangerRepository.getAllPassangersByAirplaneId(airplaneId);
    }
}
