package com.aingenious.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aingenious.model.UserDetails;
import com.aingenious.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userDetailsRepository;

    public UserDetails getUserDetailsByUsernameAndPassword(String username, String password) {
        return userDetailsRepository.findUserByUsernameAndPassword(username, password);
    }
}

