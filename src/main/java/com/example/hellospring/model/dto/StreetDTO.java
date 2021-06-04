package com.example.hellospring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StreetDTO {
    private int id;
    private String name;
    private String createdAtMLS;
    private String updatedAtMLS;
    private String deletedAtMLS;
    private String description;
    private String status;
    private String districtName;
}
