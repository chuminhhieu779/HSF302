package com.assignment1.service;


import com.assignment1.dto.response.CityResponseDTO;
import com.assignment1.entity.City;

import java.util.List;

public interface CityService {
    City findByName(String name);
    List<CityResponseDTO> findAllCity();
}
