package com.example.hellospring.controller;

import com.example.hellospring.entity.District;
import com.example.hellospring.model.dto.DistrictDTO;
import com.example.hellospring.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/districts")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @PostMapping()
    public DistrictDTO create (@RequestBody District district){
        return districtService.save(district);
    }

    @GetMapping()
    public List<DistrictDTO> findAll () {
        return districtService.findAll();
    }

    // truyen data trong postman
    @PostMapping("/seeding/generate")
    public List<DistrictDTO> seeding1 (@RequestBody List<District> districts) {
        return districtService.seeding1(districts);
    }

    // seeding hard code
    @GetMapping("/seed/generate")
    public String seeding () {
        return districtService.seeding();
    }
}
