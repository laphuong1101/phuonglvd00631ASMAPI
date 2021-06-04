package com.example.hellospring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {
    private int id;
    private String name;
    private String createdAtMLS;
    private String updatedAtMLS;
    private String deletedAtMLS;
}
