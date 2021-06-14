package com.example.hellospring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Calendar;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "name is not empty")
    private String name;
    private long createdAtMLS;
    private long updatedAtMLS;
    private long deletedAtMLS;
    private String description;
    @Enumerated(EnumType.STRING)
    private StreetStatus status;

    public enum StreetStatus {
        USING, CONSTRUCTION, REPAIRING
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "districtId", nullable = false, referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private District district;

    @Column(insertable = false, updatable = false)
    private int districtId;

    public Street(String name, String description, District district) {
        this.createdAtMLS = Calendar.getInstance().getTimeInMillis();
        this.updatedAtMLS = Calendar.getInstance().getTimeInMillis();
        this.deletedAtMLS = Calendar.getInstance().getTimeInMillis();
        this.status = StreetStatus.USING;
        this.name = name;
        this.description = description;
        this.district = district;
    }
}
