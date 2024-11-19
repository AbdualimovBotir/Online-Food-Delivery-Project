package com.botir.controller;

import com.botir.model.IngredientCategory;
import com.botir.model.IngredientsItem;
import com.botir.request.IngredientCategoryRequest;
import com.botir.request.IngredientRequest;
import com.botir.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/ingiredients")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;
    @PostMapping("/category")
    public ResponseEntity<IngredientCategory>createIngredientCategory(
            @RequestBody IngredientCategoryRequest req
    ) throws Exception {
        IngredientCategory item=ingredientService.createIngrediantCategory(req.getName(), req.getRestaurantId());
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PostMapping()
    public ResponseEntity<IngredientsItem>createIngredientItem(
            @RequestBody IngredientRequest req
    ) throws Exception {
        IngredientsItem item=ingredientService.createIngrediantItem(req.getRestaurantId(), req.getName(), req.getCategoryId());
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/stoke")
    public ResponseEntity<IngredientsItem>updateIngredientStoke(
            @PathVariable Long id
    ) throws Exception {
        IngredientsItem item=ingredientService.updateStock(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<List<IngredientsItem>>getRestaurantIngredient(
            @PathVariable Long id
    ) throws Exception {
        List<IngredientsItem> item=ingredientService.findRestaurantsIngrediants(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{id}/category")
    public ResponseEntity<List<IngredientCategory>>getRestaurantIngredientCategory(
            @PathVariable Long id
    ) throws Exception {
        List<IngredientCategory> item=ingredientService.findIngrediantCategoryByRestaurantId(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
}
