package com.sevensolutions.digitalpoint.services;

import com.sevensolutions.digitalpoint.domain.Point;
import com.sevensolutions.digitalpoint.domain.User;
import com.sevensolutions.digitalpoint.domain.dtos.PointDTO;
import com.sevensolutions.digitalpoint.domain.dtos.UserDTO;
import com.sevensolutions.digitalpoint.repositores.PointRepository;
import com.sevensolutions.digitalpoint.repositores.UserRepository;
import com.sevensolutions.digitalpoint.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PointRepository pointRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public User create(UserDTO objDTO) {
        objDTO.setId(null);
        objDTO.setPassword(encoder.encode(objDTO.getPassword()));
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

        User updatedUser = repository.save(oldObj);

        PointDTO pointDTO = new PointDTO();
        pointDTO.setUserId(updatedUser.getId());
        updateUserNamePoint(pointDTO);

        return updatedUser;
    }

    public void delete(Integer id) {
        User obj = findById(id);
        repository.deleteById(id);
    }

    public void updateUserNamePoint(PointDTO obj) {
        User user = findById(obj.getUserId());

        // Procura o Point diretamente usando PointRepository
        Optional<Point> pointOpt = pointRepository.findById(user.getId());
        if (pointOpt.isPresent()) {
            Point point = pointOpt.get();
            point.setUserName(user.getName());
            pointRepository.save(point); //

        }
    }
}
