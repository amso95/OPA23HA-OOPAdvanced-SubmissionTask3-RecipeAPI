package com.example.RecipeAPI.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recipe_table")
public class Recipe {
    @Id
    @Column(columnDefinition="INT")
    private int id;
    @Column(columnDefinition="VARCHAR(100)")
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"recipe"})
    private List<Ingredient> ingredients;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"recipe"})
    private List<Instruction> instructions;
    @Column(columnDefinition="VARCHAR(100)")
    private String creator;
    @Column(columnDefinition="VARCHAR(1)")
    private String bakingOrCooking;

    public Recipe(String name, List<Ingredient> ingredients, List<Instruction> instructions, String creator, String bakingOrCooking) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.creator = creator;
        this.bakingOrCooking = bakingOrCooking;
    }
}
/*
*
* @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredients;
    @ManyToOne
    @JoinColumn(name = "instruction_id")
    private Instruction instructions;
    *
    * */