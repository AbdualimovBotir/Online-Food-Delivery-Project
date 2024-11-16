package com.botir.request;

import com.botir.model.Address;
import com.botir.model.ContactInformation;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CreateRestaurantRequest {
    private Long id;
    private String name;
    private String description;
    private String cuisineType;
    private Address address;
    private ContactInformation contactInformation;
    private String opningHours;
    private List<String > images;
}
