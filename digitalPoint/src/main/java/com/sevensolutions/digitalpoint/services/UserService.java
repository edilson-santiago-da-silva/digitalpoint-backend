package com.sevensolutions.digitalpoint.services;

import com.sevensolutions.digitalpoint.domain.User;
import com.sevensolutions.digitalpoint.domain.dtos.UserDTO;
import com.sevensolutions.digitalpoint.repositores.UserRepository;
import com.sevensolutions.digitalpoint.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User create(UserDTO objDTO) {
        objDTO.setId(null);
        User newObj = new User(objDTO);
        return repository.save(newObj);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Integer id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("object not found! id " + id ));
    }

    public User update(Integer id, @Validated UserDTO objDTO){
        objDTO.setId(id);
        User oldObj = findById(id);
        oldObj = new User(objDTO);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        User obj = findById(id);
        repository.deleteById(id);
    }

}
