package com.example.hellospring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Credential {
    @Id
    private String accessToken;

    private String refreshToken;
    private long createdAtMLS;
    private long expiredMLS;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "userId", nullable = false, referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    @Column(insertable = false, updatable = false)
    private int userId;

    public Credential(User user) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 7);
        this.accessToken = UUID.randomUUID().toString();
        this.refreshToken = UUID.randomUUID().toString();
        this.createdAtMLS = Calendar.getInstance().getTimeInMillis();
        this.expiredMLS = calendar.getTimeInMillis();
        this.user = user;
    }
}
