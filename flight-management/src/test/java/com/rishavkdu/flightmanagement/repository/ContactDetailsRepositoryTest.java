package com.rishavkdu.flightmanagement.repository;

import com.rishavkdu.flightmanagement.entities.Address;
import com.rishavkdu.flightmanagement.entities.ContactDetails;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactDetailsRepositoryTest {

    @Autowired
    private ContactDetailsRepository contactDetailsRepository;

    @Test
    public void saveContactDetails(){
        Address address = Address.builder()
                .city("Bangalore")
                .country("India")
                .lineOne("13B/76")
                .lineTwo("HSR Layout")
                .state("Karnataka")
                .build();
        ContactDetails contactDetails = ContactDetails.builder()
                .emailId("ravi@flightmanagement.com")
                .phone("1234567890")
                .address(address)
                .build();
        contactDetailsRepository.save(contactDetails);
    }

    @Test
    public void printAllCourseDetails(){

    }
}