package com.assignment1.service.implement;

import com.assignment1.dto.response.CityResponseDTO;
import com.assignment1.entity.City;
import com.assignment1.mapper.CityMapper;
import com.assignment1.repository.CityRepository;
import com.assignment1.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository ;
    private final CityMapper cityMapper ;
    @Override
    public City findByName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public List<CityResponseDTO> findAllCity() {
        return cityRepository.findAll().stream()
                .map(cityMapper::toCityDTO)
                .toList();
    }
}
