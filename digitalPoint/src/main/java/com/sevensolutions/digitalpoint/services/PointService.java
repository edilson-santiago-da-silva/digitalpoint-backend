package com.sevensolutions.digitalpoint.services;

import com.sevensolutions.digitalpoint.domain.Point;
import com.sevensolutions.digitalpoint.domain.User;
import com.sevensolutions.digitalpoint.domain.dtos.PointDTO;
import com.sevensolutions.digitalpoint.repositores.PointRepository;
import com.sevensolutions.digitalpoint.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
public class PointService {

    @Autowired
    private PointRepository repository;

    @Autowired
    private UserService userService;

    public Point create(@Validated PointDTO objDTO){
        return repository.save(newPoint(objDTO));
    }

    public List<Point> findAll(){
        return repository.findAll();
    }

    public Point findById(Integer id){
        Optional<Point> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("object not found! id " + id ));
    }

    public Point update(Integer id, @Validated PointDTO objDTO) {
        objDTO.setId(id);
        Point oldObj = findById(id);
        oldObj = newPoint(objDTO);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        Point obj = findById(id);
        repository.deleteById(id);
    }

    private Point newPoint(PointDTO obj) {
        User user = userService.findById(obj.getUserId());

        Point point = new Point();
        if(obj.getId() != null){
            point.setId(obj.getId());
        }

        point.setUser(user);
        point.setWorkDay(obj.getWorkDay());
        point.setEntry(obj.getEntry());
        point.setExitLaunch(obj.getExitLaunch());
        point.setEntryLaunch(obj.getExitLaunch());
        point.setExit(obj.getExit());

        return point;
    }


}
