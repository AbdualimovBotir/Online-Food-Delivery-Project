package com.botir.repository;

import com.botir.model.IngredientCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientCategoryRepository extends JpaRepository<IngredientCategory,Long> {
    List<IngredientCategory> findByRestaurantId(long id);
}
