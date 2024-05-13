package com.example.RecipeAPI.controllers;

import com.example.RecipeAPI.objects.Ingredient;
import com.example.RecipeAPI.objects.Instruction;
import com.example.RecipeAPI.repositories.IngredientRepository;
import com.example.RecipeAPI.services.IngredientService;
import com.example.RecipeAPI.services.InstructionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
@CrossOrigin(origins = "*")
public class IngredientController {
    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    // Get mapping to get a list of BlogPost objects.
    @GetMapping("/get-all")
    public List<Ingredient> getAllBlogPosts() {
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/get-next-id")
    public int getNextIngredientId() {
        return ingredientService.getNextId();
    }
    @PostMapping("/create")
    public ResponseEntity<String> createNewBlogPost(@RequestBody Ingredient ingredient){
            // Check if addIngredient successes or not.
            boolean success = ingredientService.addIngredient(ingredient);
            if(success) {
                // Post request succeeded.
                return ResponseEntity.status(HttpStatus.CREATED).body("Added successfully");
            }
            // Post request failed.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add recipe");
    }
    @PutMapping("/edit")
    public ResponseEntity<String> editRecipe(@RequestBody Ingredient ingredient){
        // Check if updateInstruction successes or not.
        boolean success = ingredientService.updateIngredient(ingredient);
        if(success) {
            // Put request succeeded.
            return ResponseEntity.status(HttpStatus.OK).body("Edited successfully");
        }
        // Put request failed.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to edit ingredient");
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteRecipeById(int id) {
        // Check if deleteInstructionById successes or not.
        boolean success = ingredientService.deleteIngredientById(id);
        if (success) {
            // Delete request succeeded.
            return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully") ;
        }
        // Delete request failed.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to deleted ingredient");
    }

}
