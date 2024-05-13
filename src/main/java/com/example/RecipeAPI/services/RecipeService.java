package com.example.RecipeAPI.services;

import com.example.RecipeAPI.objects.Recipe;
import com.example.RecipeAPI.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RecipeService {
    private RecipeRepository repo;

    public RecipeService(RecipeRepository recipeRepository){
        this.repo = recipeRepository;
    }

    public ArrayList<Recipe> getAllRecipes(){
        return (ArrayList<Recipe>) repo.findAll();
    }

    public  int getNextId(){
        return repo.findAll().getLast().getId() + 1;
    }

    public boolean addRecipe(Recipe recipe) {
        Recipe newRecipe = repo.save(recipe);
        recipe.setId(newRecipe.getId());
        return true;
    }

    public boolean updateRecipe(Recipe recipe) {
        if(repo.existsById(recipe.getId())){
            repo.save(recipe);
            return true;
        }
        return false;
    }

    public boolean deleteRecipeById(int id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
