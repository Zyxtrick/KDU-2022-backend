package com.rishavkdu.flightmanagement.repository;

import com.rishavkdu.flightmanagement.entities.Address;
import com.rishavkdu.flightmanagement.entities.ContactDetails;
import com.rishavkdu.flightmanagement.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveContactDetails(){
        Address address = Address.builder()
                .city("Bangalore")
                .country("India")
                .lineOne("12B/125")
                .lineTwo("BTM Layout")
                .state("Karnataka")
                .build();
        ContactDetails contactDetails = ContactDetails.builder()
                .emailId("ramesh@flightmanagement.com")
                .phone("1234567820")
                .address(address)
                .build();
        User user = User.builder()
                .contactDetails(contactDetails)
                .emailId("ramesh@flightmanagement.com")
                .userName("Ramesh")
                .password("Ramesh@123")
                .build();
        userRepository.save(user);
    }

    @Test
    public void printAllUsers() {
        List<User> users = userRepository.findAll();
        System.out.println("Users : " + users);
    }
}