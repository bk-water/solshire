package com.solshire.service.impl;

import com.solshire.model.domain.City;
import com.solshire.service.CityService;
import org.springframework.stereotype.Service;

@Service("cityService")
public class CityServiceImpl extends BaseServiceImpl<City, Integer> implements CityService {
}