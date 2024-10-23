package com.sevensolutions.digitalpoint.services;

import com.sevensolutions.digitalpoint.domain.Point;
import com.sevensolutions.digitalpoint.repositores.PointRepository;
import com.sevensolutions.digitalpoint.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PointService {

    @Autowired
    private PointRepository repository;

    public Point findById(Integer id){
        Optional<Point> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("object not found! id " + id ));
    }

    public List<Point> findAll(){
        return repository.findAll();
    }
}
