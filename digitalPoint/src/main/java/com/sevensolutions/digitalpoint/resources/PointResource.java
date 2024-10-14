package com.sevensolutions.digitalpoint.resources;

import com.sevensolutions.digitalpoint.domain.Point;
import com.sevensolutions.digitalpoint.services.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/points")
public class PointResource {

    @Autowired
    private PointService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Point> findById(@PathVariable Integer id){
        Point obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
