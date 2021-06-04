package com.example.hellospring.controller;

import com.example.hellospring.entity.Street;
import com.example.hellospring.model.dto.StreetDTO;
import com.example.hellospring.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/streets")
public class StreetController {
    @Autowired
    private StreetService streetService;

    // create
    @PostMapping()
    public StreetDTO create (@RequestBody Street street){
        return streetService.save(street);
    }

    // find all
    @GetMapping()
    public List<StreetDTO> findAll () {
        return streetService.findAll();
    }

    // find by district name and street name
    @GetMapping("/find-by-district-and-name")
    public List<StreetDTO> findByDistrictAndName (
            @RequestParam(name = "district", required = false, defaultValue = "") String districtName,
            @RequestParam(name = "name", required = false, defaultValue = "") String name) {
        return streetService.findByDistrictAndName(districtName, name);
    }
}
