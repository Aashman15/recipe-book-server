package com.recipebook.controller;

import com.recipebook.model.Recipe;
import com.recipebook.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RecipeRestController {
    @Autowired
    RecipeRepository recipeRepository;

    @PutMapping("/saveRecipes")
    List<Recipe> deleteRecipesAndSaveRecipes(@RequestBody List<Recipe> recipes) {
        recipeRepository.deleteAll();
        return recipeRepository.saveAll(recipes);
    }

    @GetMapping("/getRecipes")
    List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }
}
