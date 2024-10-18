package com.sevensolutions.digitalpoint.services;

import com.sevensolutions.digitalpoint.domain.User;
import com.sevensolutions.digitalpoint.repositores.UserRepository;
import com.sevensolutions.digitalpoint.services.exceptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findById(Integer id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("object not found! id " + id ));
    }
}
