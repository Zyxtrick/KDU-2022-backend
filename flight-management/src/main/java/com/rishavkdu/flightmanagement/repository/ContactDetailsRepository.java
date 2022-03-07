package com.rishavkdu.flightmanagement.repository;

import com.rishavkdu.flightmanagement.entities.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Long> {
}
