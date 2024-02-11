package com.tech.assesment.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tech.assesment.constants.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RetailUser extends AuditMetaData{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String contact;
    private UserType userType;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name="item_ID",referencedColumnName="id")
    List<Item> agents = new ArrayList<>();

    public RetailUser(int i, String john, String s, UserType customer) {
        super();
    }
}
