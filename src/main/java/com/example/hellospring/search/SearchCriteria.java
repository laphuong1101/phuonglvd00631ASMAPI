package com.example.hellospring.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {
    private String key; // ten truong
    private String operation; // kieu tim kiem
    private Object value; // gia tri loc, so sanh
}
