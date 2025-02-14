package com.botir.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Embeddable
public class RestaurantDto {
    private String title;
    @Column(length = 1000)
    private List<String>images;
    private String description;
    private Long id;
}
