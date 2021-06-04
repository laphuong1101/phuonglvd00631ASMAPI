package com.example.hellospring.service;

import com.example.hellospring.entity.District;
import com.example.hellospring.entity.Street;
import com.example.hellospring.model.dto.DistrictDTO;
import com.example.hellospring.model.mapper.DistrictMapper;
import com.example.hellospring.repository.DistrictRepository;
import com.example.hellospring.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private StreetRepository streetRepository;

    // save
    public DistrictDTO save (District district) {
        district.setCreatedAtMLS(Calendar.getInstance().getTimeInMillis());
        district.setUpdatedAtMLS(Calendar.getInstance().getTimeInMillis());
        district.setDeletedAtMLS(Calendar.getInstance().getTimeInMillis());

        if (district.getStreets() != null) {
            for (Street item : district.getStreets()) {
                item.setCreatedAtMLS(Calendar.getInstance().getTimeInMillis());
                item.setUpdatedAtMLS(Calendar.getInstance().getTimeInMillis());
                item.setDeletedAtMLS(Calendar.getInstance().getTimeInMillis());
                item.setStatus(Street.StreetStatus.USING);
            }
        }
        districtRepository.save(district);
        DistrictDTO rs = DistrictMapper.districtDTO(district);
        return rs;
    }

    // find all
    public List<DistrictDTO> findAll () {
        List<District> districts = districtRepository.findAll();
        List<DistrictDTO> districtDTOList = new ArrayList<>();

        for (District item : districts) {
            districtDTOList.add(DistrictMapper.districtDTO(item));
        }

        return districtDTOList;
    }

    // seeding
    public List<DistrictDTO> seeding1(List<District> districts) {
        List<DistrictDTO> districtDTOList = new ArrayList<>();
        for (District item : districts) {
            districtDTOList.add(DistrictMapper.districtDTO(item));
        }
        districtRepository.saveAll(districts);
        return districtDTOList;
    }

    // seeding hard code
    public String seeding() {
        District cauGiay = new District("cau giay");
        District tuLiem = new District("tu liem");
        District dongDa = new District("dong da");
        District haiBaTrung = new District("hai ba trung");
        District hoangMai = new District("hoang mai");

        List<District> districts = new ArrayList<>();
        districts.add(cauGiay);
        districts.add(tuLiem);
        districts.add(dongDa);
        districts.add(haiBaTrung);
        districts.add(hoangMai);
        districtRepository.saveAll(districts);

        Street tranDuyHung = new Street("tran duy hung", "con duong sung suong", cauGiay);
        Street xuanThuy = new Street("xuan thuy", "hello", cauGiay);
        Street phamHung = new Street("pham hung", "duong dua", tuLiem);
        Street leDucTho = new Street("le duc tho", "ldt", tuLiem);
        Street xaDan = new Street("xa dan", "duong dua 2", dongDa);
        Street thaiHa = new Street("thai ha", "hello", dongDa);
        Street daiCoViet = new Street("dai co viet", "hello", haiBaTrung);
        Street giaiPhong = new Street("giai phong", "hello", haiBaTrung);
        Street tamChinh = new Street("tam chinh ", "3 chinh", hoangMai);
        Street daiTu = new Street("dai tu ", "hello", hoangMai);
        List<Street> streets = new ArrayList<>();
        streets.add(tranDuyHung);
        streets.add(xuanThuy);
        streets.add(phamHung);
        streets.add(leDucTho);
        streets.add(xaDan);
        streets.add(thaiHa);
        streets.add(daiCoViet);
        streets.add(giaiPhong);
        streets.add(tamChinh);
        streets.add(daiTu);
        streetRepository.saveAll(streets);

        return "OK";
    }
}
