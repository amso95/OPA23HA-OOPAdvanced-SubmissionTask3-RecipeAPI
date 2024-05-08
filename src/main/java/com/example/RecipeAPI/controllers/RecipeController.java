package com.example.RecipeAPI.controllers;

import com.example.RecipeAPI.objects.Recipe;
import com.example.RecipeAPI.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
@CrossOrigin(origins = "*")
public class RecipeController {
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    // Get mapping to get a list of BlogPost objects.
    @GetMapping("/get-all")
    public List<Recipe> getAllBlogPosts() {
        return recipeService.getAllRecipes();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createNewRecipe(@RequestBody Recipe recipe){
            // Check if addRecipe successes or not.
            boolean success = recipeService.addRecipe(recipe);
            if(success) {
                // Post request succeeded.
                return ResponseEntity.status(HttpStatus.CREATED).body("Added successfully");
            }
            // Post request failed.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add recipe");
    }
    @PutMapping("/edit")
    public ResponseEntity<String> editRecipe(@RequestBody Recipe recipe){
        // Check if updateRecipe successes or not.
        boolean success = recipeService.updateRecipe(recipe);
        if(success) {
            // Put request succeeded.
            return ResponseEntity.status(HttpStatus.OK).body("Edited successfully");
        }
        // Put request failed.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to edit recipe");
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteRecipeById(int id) {
        // Check if deleteRecipeById successes or not.
        boolean success = recipeService.deleteRecipeById(id);
        if (success) {
            // Delete request succeeded.
            return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully") ;
        }
        // Delete request failed.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to deleted recipe");
    }

}
