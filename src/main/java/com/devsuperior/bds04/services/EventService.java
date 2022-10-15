package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.EventDto;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.EventRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public EventDto insert(EventDto eventDto) {
        var event = new Event();
        BeanUtils.copyProperties(eventDto, event);
        event.setCity(new City(eventDto.getCityId(), null));
        event = eventRepository.save(event);
        return new EventDto(event);
    }

    public Page<EventDto> findAll(Pageable pageable) {
        var list = eventRepository.findAll(pageable);
        return list.map(event -> new EventDto(event));
    }
}
