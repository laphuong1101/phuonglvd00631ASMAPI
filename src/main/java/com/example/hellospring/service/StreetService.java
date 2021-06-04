package com.example.hellospring.service;

import com.example.hellospring.entity.District;
import com.example.hellospring.entity.Street;
import com.example.hellospring.model.dto.StreetDTO;
import com.example.hellospring.model.mapper.StreetMapper;
import com.example.hellospring.repository.DistrictRepository;
import com.example.hellospring.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class StreetService {
    @Autowired
    private StreetRepository streetRepository;

    @Autowired
    private DistrictRepository districtRepository;

    // save
    public StreetDTO save (Street street) {
        street.setCreatedAtMLS(Calendar.getInstance().getTimeInMillis());
        street.setUpdatedAtMLS(Calendar.getInstance().getTimeInMillis());
        street.setDeletedAtMLS(Calendar.getInstance().getTimeInMillis());
        street.setStatus(Street.StreetStatus.USING);

        if (street.getDistrict() == null) {
            District district = districtRepository.findById(street.getDistrictId()).orElse(null);
            street.setDistrict(district);
        } else {
            street.getDistrict().setCreatedAtMLS(Calendar.getInstance().getTimeInMillis());
            street.getDistrict().setUpdatedAtMLS(Calendar.getInstance().getTimeInMillis());
            street.getDistrict().setDeletedAtMLS(Calendar.getInstance().getTimeInMillis());
        }
        streetRepository.save(street);
        StreetDTO rs = StreetMapper.streetDTO(street);
        return rs;
    }

    // find all
    public List<StreetDTO> findAll () {
        List<Street> streets = streetRepository.findAll();
        List<StreetDTO> streetDTOS = new ArrayList<>();

        for (Street item : streets) {
            streetDTOS.add(StreetMapper.streetDTO(item));
        }
        return streetDTOS;
    }

    // find by district name and street name
    public List<StreetDTO> findByDistrictAndName (String districtName, String name) {
        List<Street> streets = streetRepository.findByDistrictNameAndName(districtName, name);

        List<StreetDTO> streetDTOS = new ArrayList<>();

        for (Street item : streets) {
            streetDTOS.add(StreetMapper.streetDTO(item));
        }
        return streetDTOS;
    }
}
