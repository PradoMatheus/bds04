package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.CityDto;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Transactional
    public CityDto insert(CityDto cityDto) {
        var city = new City();
        BeanUtils.copyProperties(cityDto, city);
        return new CityDto(cityRepository.save(city));
    }

    @Transactional(readOnly = true)
    public List<CityDto> findAll() {
        var list = cityRepository.findAll(Sort.by("name"));
        return list.stream().map(city -> new CityDto(city)).collect(Collectors.toList());
    }
}
