package com.botir.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
public class ContactInformation {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    private String email;
    private String mobile;
    private String twitter;
    private String instagram;
}
