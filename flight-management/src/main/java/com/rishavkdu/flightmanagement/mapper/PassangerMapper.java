package com.rishavkdu.flightmanagement.mapper;

import com.rishavkdu.flightmanagement.dto.PassangerDTO;
import com.rishavkdu.flightmanagement.entities.Passenger;
import com.rishavkdu.flightmanagement.service.FlightInstance.FlightInstanceService;
import com.rishavkdu.flightmanagement.service.User.UserService;
import com.rishavkdu.flightmanagement.service.User.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PassangerMapper {

    @Autowired
    private UserService userService;

    @Autowired
    private FlightInstanceService flightInstanceService;

    public Passenger toEntity(PassangerDTO passangerDTO){
        Passenger passenger = Passenger.builder()
                .age(passangerDTO.getAge())
                .emailId(passangerDTO.getEmailId())
                .passangerName(passangerDTO.getPassangerName())
                .phone(passangerDTO.getPhone())
                .type(passangerDTO.getType())
                .seatNumber(passangerDTO.getSeatNumber())
                .sex(passangerDTO.getSex())
                .cancelled(passangerDTO.getCancelled())
                .confirmed(passangerDTO.getConfirmed())
                .flightInstance(flightInstanceService.getFlightById(passangerDTO.getInstanceId()))
                .user(userService.getUserById(passangerDTO.getUserId()))
                .build();
        return passenger;
    }

}
