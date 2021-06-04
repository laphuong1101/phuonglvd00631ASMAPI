package com.example.hellospring.model.mapper;

import com.example.hellospring.entity.District;
import com.example.hellospring.model.dto.DistrictDTO;
import com.example.hellospring.utility.Utility;

public class DistrictMapper {
    public static DistrictDTO districtDTO (District district) {
        DistrictDTO tmp = new DistrictDTO();
        tmp.setId(district.getId());
        tmp.setName(district.getName());
        tmp.setCreatedAtMLS(Utility.convertLongToDate(district.getCreatedAtMLS()));
        tmp.setUpdatedAtMLS(Utility.convertLongToDate(district.getUpdatedAtMLS()));
        tmp.setDeletedAtMLS(Utility.convertLongToDate(district.getDeletedAtMLS()));
        return tmp;
    }
}
