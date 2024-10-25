package com.sevensolutions.digitalpoint.services;

import com.sevensolutions.digitalpoint.domain.User;
import com.sevensolutions.digitalpoint.repositores.UserRepository;
import com.sevensolutions.digitalpoint.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Integer id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("object not found! id " + id ));
    }

    public void delete(Integer id) {
        User obj = findById(id);
        repository.deleteById(id);
    }



}
