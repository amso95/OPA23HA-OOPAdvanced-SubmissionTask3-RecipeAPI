package com.example.RecipeAPI.services;

import com.example.RecipeAPI.objects.Ingredient;
import com.example.RecipeAPI.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class IngredientService {
    private IngredientRepository repo;

    public IngredientService(IngredientRepository ingredientRepository){
        this.repo = ingredientRepository;
    }
    public ArrayList<Ingredient> getAllIngredients(){
        return (ArrayList<Ingredient>) repo.findAll();
    }

    public  int getNextId(){
        return repo.findAll().getLast().getId() + 1;
    }
    public boolean addIngredient(Ingredient ingredient) {
        Ingredient newIngredient = repo.save(ingredient);
        ingredient.setId(newIngredient.getId());
        return true;
    }

    public boolean updateIngredient(Ingredient ingredient) {
        if(repo.existsById(ingredient.getId())){
            repo.save(ingredient);
            return true;
        }
        return false;
    }

    public boolean deleteIngredientById(int id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
