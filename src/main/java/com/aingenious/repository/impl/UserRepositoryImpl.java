package com.aingenious.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import com.aingenious.model.UserDetails;
import com.aingenious.repository.UserRepository;


@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserDetails findUserByUsernameAndPassword(String username, String password) {
        String jpql = "SELECT u FROM UserDetails u WHERE u.username = :username AND u.password = :password";
        Query query = entityManager.createQuery(jpql, UserDetails.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            return (UserDetails) query.getSingleResult();
        } catch (Exception e) {
            return null; // or handle the exception as needed
        }
    }
}

