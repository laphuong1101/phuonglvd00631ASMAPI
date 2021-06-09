package com.example.hellospring.controller;

import com.example.hellospring.entity.Street;
import com.example.hellospring.model.dto.StreetDTO;
import com.example.hellospring.repository.StreetRepository;
import com.example.hellospring.search.SearchCriteria;
import com.example.hellospring.search.StreetSpecification;
import com.example.hellospring.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/streets")
public class StreetController {
    @Autowired
    private StreetService streetService;

    @Autowired
    StreetRepository streetRepository;

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

    @GetMapping("/search")
    public Iterable<Street> search (@RequestParam(name = "keyword", required = false) Optional<String> keyword,
                                    @RequestParam(name = "start", required = false) Optional<String> start,
                                    @RequestParam(name = "end", required = false) Optional<String> end) {

        Specification<Street> specification = Specification.where(null);
        if (keyword.isPresent() && keyword.get().length() > 0) {
            specification = specification.and(new StreetSpecification(new SearchCriteria("name", "like" , keyword.get())));
        }
        if (start.isPresent() && start.get().length() > 0) {
            specification = specification.and(new StreetSpecification(new SearchCriteria("createdAtMLS", ">=" , start.get())));
        }
        if (end.isPresent() && end.get().length() > 0) {
            specification = specification.and(new StreetSpecification(new SearchCriteria("deletedAtMLS", "<=" , end.get())));
        }
        return streetRepository.findAll(specification);
    }
}
