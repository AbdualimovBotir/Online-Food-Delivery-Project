package com.botir.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientCategoryRequest {
    private String name;
    private Long restaurantId;
}
