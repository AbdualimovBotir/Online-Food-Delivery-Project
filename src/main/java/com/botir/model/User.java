package com.botir.model;

import com.botir.dto.RestaurantDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String email;
    @JsonProperty(access =JsonProperty.Access.WRITE_ONLY)
    private String password;

//    @JsonIgnore
    private USER_ROLE role=USER_ROLE.ROLE_CUSTOMER;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private List<Order> orders=new ArrayList<>();

    @ElementCollection
    private List<RestaurantDto> favorites=new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Address> addresses=new ArrayList<>();
    private String status;
}
