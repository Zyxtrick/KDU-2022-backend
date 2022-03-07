package com.rishavkdu.flightmanagement.controller;

import com.rishavkdu.flightmanagement.dto.PassangerDTO;
import com.rishavkdu.flightmanagement.entities.Passenger;
import com.rishavkdu.flightmanagement.mapper.PassangerMapper;
import com.rishavkdu.flightmanagement.service.Passanger.PassangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PassengerController {

    @Autowired
    private PassangerMapper mapper;

    @Autowired
    private PassangerService passangerService;

    @PostMapping("/bookTickets")
    public Passenger bookTickets(@RequestBody PassangerDTO passangerDTO){
        Passenger passenger = mapper.toEntity(passangerDTO);
        return passangerService.savePassenger(passenger);
    }

    @GetMapping("/getTickets")
    public List<Passenger> getTickets(){
        return passangerService.getAllPassengers();
    }

    @GetMapping("/getAllPassangersOnAFlight/{airplaneId}")
    public List<Passenger> getAllPassangersOnAFlight(@PathVariable String airplaneId){
        return passangerService.getAllPassangersByAirPlaneId(airplaneId);
    }

}
