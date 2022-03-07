package com.rishavkdu.flightmanagement.repository;

import com.rishavkdu.flightmanagement.entities.Address;
import com.rishavkdu.flightmanagement.entities.ContactDetails;
import com.rishavkdu.flightmanagement.entities.Transaction;
import com.rishavkdu.flightmanagement.entities.User;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void saveTransactionWithUser() {
        Address address = Address.builder()
                .lineOne("45C/98")
                .lineTwo("Koramangala")
                .city("Bangalore")
                .state("Karnataka")
                .country("India")
                .build();
        ContactDetails contactDetails = ContactDetails.builder()
                .address(address)
                .contactId(2345678901L)
                .emailId("rohit@flightmanagement.com")
                .build();
        User user = User.builder()
                .userName("Rohit")
                .password("Rohit@123")
                .contactDetails(contactDetails)
                .build();

        Transaction transaction = Transaction.builder()
                .amount(1000.0)
                .transactionId(100001L)
                .gateway("Razorpay")
                .user(user)
                .paymentMode("UPI")
                .responseMessage("Successfully completed")
                .status("PASSED")
                .build();

        transactionRepository.save(transaction);
    }
}