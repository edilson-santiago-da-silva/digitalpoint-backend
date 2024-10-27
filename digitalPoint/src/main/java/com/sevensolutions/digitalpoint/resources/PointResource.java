package com.sevensolutions.digitalpoint.resources;

import com.sevensolutions.digitalpoint.domain.Point;
import com.sevensolutions.digitalpoint.domain.dtos.PointDTO;
import com.sevensolutions.digitalpoint.domain.dtos.UserDTO;
import com.sevensolutions.digitalpoint.services.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/points")
public class PointResource {

    @Autowired
    private PointService service;

    @PostMapping
    public ResponseEntity<PointDTO> create(@Validated @RequestBody PointDTO objDTO) {
        Point obj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<PointDTO>> FindAll(){
        List<Point> list = service.findAll();
        List<PointDTO> listDTO = list.stream().map(PointDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PointDTO> findById(@PathVariable Integer id){
        Point obj = service.findById(id);
        return ResponseEntity.ok().body(new PointDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PointDTO> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
