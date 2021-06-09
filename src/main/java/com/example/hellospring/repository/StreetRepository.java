package com.example.hellospring.repository;

import com.example.hellospring.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetRepository extends JpaRepository<Street, Integer>, JpaSpecificationExecutor<Street> {
    public List<Street> findByDistrictNameAndName (String districtName, String name);


}
