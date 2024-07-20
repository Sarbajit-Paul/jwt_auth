package com.aingenious.repository;

import com.aingenious.model.UserDetails;

public interface UserRepository {
    UserDetails findUserByUsernameAndPassword(String username, String password);
}

