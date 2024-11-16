package com.botir.request;

import com.botir.model.Category;
import com.botir.model.IngredientsItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateFoodRequest {
    private String name;
    private String description;
    private Long price;
    private Category category;
    private List<String>images;
    private Long restaurantId;
    private boolean vegetarian;
    private boolean seasionial;
    private List<IngredientsItem>ingredients;
}
