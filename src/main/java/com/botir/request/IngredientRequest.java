package com.botir.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientRequest {
    private String name;
    private Long categoryId;
    private Long restaurantId;
}
