package com.rishavkdu.springAnnotations.demo;

import com.rishavkdu.springAnnotations.demo.models.Admin;
import com.rishavkdu.springAnnotations.demo.models.Guest;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class UserUtilityConfig {

    @Bean(name = "newGuest")
    public Guest createGuest() {
        return new Guest();
    }

    @Bean(name = "newAdmin")
    public Admin createAdmin() {
        return new Admin();
    }


}