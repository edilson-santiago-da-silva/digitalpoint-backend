package com.sevensolutions.digitalpoint.resources;

import com.sevensolutions.digitalpoint.domain.Point;
import com.sevensolutions.digitalpoint.domain.dtos.PointDTO;
import com.sevensolutions.digitalpoint.services.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/points")
public class PointResource {

    @Autowired
    private PointService service;

    @GetMapping
    public ResponseEntity<List<PointDTO>> FindAll(){
        List<Point> list = service.findAll();
        List<PointDTO> listDTO = list.stream().map(PointDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Point> findById(@PathVariable Integer id){
        Point obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
