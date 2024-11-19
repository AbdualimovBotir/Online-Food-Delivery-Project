package com.botir.service;

import com.botir.model.IngredientCategory;
import com.botir.model.IngredientsItem;

import java.util.List;

public interface IngredientService {
    public IngredientCategory createIngrediantCategory(String name ,Long restaurantId)throws Exception;
    public IngredientCategory findIngrediantCategorybyId(Long id)throws Exception;

    IngredientCategory findIngrediantCategoryById(Long id) throws Exception;

    public List<IngredientCategory>findIngrediantCategoryByRestaurantId(Long id)throws Exception;
    public IngredientsItem createIngrediantItem(Long restaurantId,String ingrediantName,Long categotyId)throws Exception;
    public List<IngredientsItem> findRestaurantsIngrediants(Long restaurantId);
    public IngredientsItem updateStock(Long id)throws Exception;
}
