package com.example.hellospring.model.mapper;

import com.example.hellospring.entity.Street;
import com.example.hellospring.model.dto.StreetDTO;
import com.example.hellospring.utility.Utility;

public class StreetMapper {
    public static StreetDTO streetDTO (Street street) {
        StreetDTO tmp = new StreetDTO();
        tmp.setId(street.getId());
        tmp.setName(street.getName());
        tmp.setCreatedAtMLS(Utility.convertLongToDate(street.getCreatedAtMLS()));
        tmp.setUpdatedAtMLS(Utility.convertLongToDate(street.getUpdatedAtMLS()));
        tmp.setDeletedAtMLS(Utility.convertLongToDate(street.getDeletedAtMLS()));
        tmp.setDescription(street.getDescription());
        tmp.setStatus(String.valueOf(street.getStatus()));
        tmp.setDistrictName(street.getDistrict().getName());
        return tmp;
    }
}
