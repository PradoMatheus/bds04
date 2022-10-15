package com.devsuperior.bds04.resource;

import com.devsuperior.bds04.dto.CityDto;
import com.devsuperior.bds04.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityResource {

    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<CityDto> insert(@Valid @RequestBody CityDto cityDto) {
        var dto = cityService.insert(cityDto);
        var URI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(URI).body(dto);
    }

    @GetMapping()
    public ResponseEntity<List<CityDto>> findAll() {
        var list = cityService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
