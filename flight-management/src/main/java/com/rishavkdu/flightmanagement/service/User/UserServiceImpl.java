package com.rishavkdu.flightmanagement.service.User;

import com.rishavkdu.flightmanagement.entities.User;
import com.rishavkdu.flightmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long userId){
        return userRepository.findById(userId).get();
    }
}
