package com.solshire.controller;

import com.solshire.model.domain.City;
import com.solshire.service.CityService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CityController
 *
 * @author trang
 */
@RestController
@RequestMapping(path = "/city", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
@Api(tags = "Admin")
public class CityController {

    @Autowired
    private CityService cityService;
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<City> getById(@PathVariable Integer id) {
//        City city = cityService.selectByPk(id);
//        return ResponseEntity.ok(city);
//    }
//
//    @GetMapping("/list/{ids}")
//    public ResponseEntity<List<City>> getByIds(@PathVariable List<Integer> ids) {
//        List<City> list = cityService.selectByIds(ids);
//        return ResponseEntity.ok(list);
//    }

}