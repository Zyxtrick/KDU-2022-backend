package com.rishavkdu.flightmanagement.service.FlightInstance;


import com.rishavkdu.flightmanagement.entities.FlightInstance;
import com.rishavkdu.flightmanagement.repository.AirplaneRepository;
import com.rishavkdu.flightmanagement.repository.FlightInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FlightInstanceServiceImpl implements FlightInstanceService {

    @Autowired
    private FlightInstanceRepository flightInstanceRepository;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Override
    public FlightInstance updateFlightInstance(String instanceId, FlightInstance flightInstance) {
        FlightInstance oldFlightInstance = flightInstanceRepository.findById(instanceId).get();

        if(Objects.nonNull((flightInstance.getBSeats()))  && (flightInstance.getBSeats() != 0)){
            oldFlightInstance.setBSeats(flightInstance.getBSeats());
        }
        if(Objects.nonNull((flightInstance.getESeats()))  && (flightInstance.getESeats() != 0)){
            oldFlightInstance.setESeats(flightInstance.getESeats());
        }
        if(Objects.nonNull((flightInstance.getFSeats()))  && (flightInstance.getFSeats() != 0)){
            oldFlightInstance.setFSeats(flightInstance.getFSeats());
        }
        if(Objects.nonNull((flightInstance.getBCost()))  && (flightInstance.getBCost() != 0)){
            oldFlightInstance.setBCost(flightInstance.getBCost());
        }
        if(Objects.nonNull((flightInstance.getECost()))  && (flightInstance.getECost() != 0)){
            oldFlightInstance.setECost(flightInstance.getECost());
        }
        if(Objects.nonNull((flightInstance.getFCost()))  && (flightInstance.getFCost() != 0)){
            oldFlightInstance.setFCost(flightInstance.getFCost());
        }

        if(Objects.nonNull((flightInstance.getArrival()))  && !"".equalsIgnoreCase(flightInstance.getArrival())){
            oldFlightInstance.setArrival(flightInstance.getArrival());
        }
        if(Objects.nonNull((flightInstance.getDeparture()))  && !"".equalsIgnoreCase(flightInstance.getDeparture())){
            oldFlightInstance.setDeparture(flightInstance.getDeparture());
        }
        if(Objects.nonNull((flightInstance.getAirplane()))){
            oldFlightInstance.setAirplane(flightInstance.getAirplane());
        }
        if(Objects.nonNull((flightInstance.getRoutePlane()))){
            oldFlightInstance.setRoutePlane(flightInstance.getRoutePlane());
        }

        return flightInstanceRepository.save(oldFlightInstance);
    }

    @Override
    public FlightInstance getFlightById(String instanceId) {
        return flightInstanceRepository.findById(instanceId).get();
    }

    @Override
    public List<FlightInstance> viewFlightDetails() {
        return flightInstanceRepository.getAllFlightDetails();
    }
}
