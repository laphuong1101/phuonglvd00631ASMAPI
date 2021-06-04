package com.example.hellospring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long createdAtMLS;
    private long updatedAtMLS;
    private long deletedAtMLS;

    @OneToMany(mappedBy="district", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private Set<Street> streets = new HashSet<>();

    public void setStreets(Set<Street> streets) {
        this.streets = streets;
        for(Street s : streets) {
            s.setDistrict(this);
        }
    }

    public District(String name) {
        this.createdAtMLS = Calendar.getInstance().getTimeInMillis();
        this.updatedAtMLS = Calendar.getInstance().getTimeInMillis();
        this.deletedAtMLS = Calendar.getInstance().getTimeInMillis();
        this.name = name;
    }
}
