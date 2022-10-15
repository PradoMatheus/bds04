package com.devsuperior.bds04.resource;

import com.devsuperior.bds04.dto.CityDto;
import com.devsuperior.bds04.dto.EventDto;
import com.devsuperior.bds04.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/events")
public class EventResource {

    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<EventDto> insert(@Valid @RequestBody EventDto eventDto) {
        var dto = eventService.insert(eventDto);
        var URI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(URI).body(dto);
    }

    @GetMapping()
    public ResponseEntity<Page<EventDto>> findAll(Pageable pageable) {
        var list = eventService.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }
}
