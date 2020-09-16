package com.recipebook.controller;

import com.recipebook.model.Recipe;
import com.recipebook.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class RecipeRestController {
    @Autowired
    RecipeRepository recipeRepository;

    @PutMapping("/saveRecipes")
    @ResponseBody
    List<Recipe> deleteRecipesAndSaveRecipes(@RequestBody List<Recipe> recipes) {
        recipeRepository.deleteAll();
        return recipeRepository.saveAll(recipes);
    }

    @GetMapping("/getRecipes")
    @ResponseBody
    List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    @GetMapping("/home")
    public ModelAndView getHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("response", "Hello World !!!");
        return modelAndView;
    }
}
