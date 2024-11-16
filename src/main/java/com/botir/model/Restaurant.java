package com.botir.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private User owner;

    private String name;

    private String description;
    private String cuisineType;
    @ManyToOne
    private Address address;

    @Embedded
    private ContactInformation contactInformation;

    private String openingHours;
//    private String reviews;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Order> orders=new ArrayList<>();

//    private String numRating;
    @ElementCollection
    @Column(length = 1000)
    private List<String> images;

    private LocalDate registrationDate;

    private boolean open;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    private List<Food> foods=new ArrayList<>();
}
