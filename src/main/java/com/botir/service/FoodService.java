package com.botir.service;

import com.botir.model.Category;
import com.botir.model.Food;
import com.botir.model.Restaurant;
import com.botir.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);
    void deleteFood(Long foodId)throws Exception;
    public List<Food>getRestaurantsFood(Long restaurantId,
                                        boolean isVegitarian,
                                        boolean isNonveg,
                                        boolean isSeasonal,
                                        String foodCategory
    );
    public List<Food>searchFood(String keyword);
    public Food findFoodById(Long foodId)throws Exception;
    public Food updateAvailibilityStatus(Long foodId)throws Exception;

}
