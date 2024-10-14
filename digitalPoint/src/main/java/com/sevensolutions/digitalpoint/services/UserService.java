package com.sevensolutions.digitalpoint.services;

import com.sevensolutions.digitalpoint.domain.User;
import com.sevensolutions.digitalpoint.repositores.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findById(Integer id){
        Optional<User> obj = repository.findById(id);
        return obj.orElse(null);
    }
}
