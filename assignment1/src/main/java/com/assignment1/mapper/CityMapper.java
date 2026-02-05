package com.assignment1.mapper;

import com.assignment1.dto.response.CityResponseDTO;
import com.assignment1.entity.City;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {
    public CityResponseDTO toCityDTO(City city){
        return new CityResponseDTO(
                city.getName()
        );
    }
}
