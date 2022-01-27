package com.rishavkdu.springAnnotations.demo;


import com.rishavkdu.springAnnotations.demo.models.Admin;
import com.rishavkdu.springAnnotations.demo.models.Guest;
import com.rishavkdu.springAnnotations.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserUtility {
    @Autowired
    @Qualifier("newGuest")
    private Guest guest;

    @Autowired
    @Qualifier("newAdmin")
    private Admin admin;

    public void removeUser() {
        guest.removeUser();
        admin.removeUser();
    }
}
