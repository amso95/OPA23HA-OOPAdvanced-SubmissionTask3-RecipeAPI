package com.example.RecipeAPI.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ingredient_table")
public class Ingredient{
    @Id
    @Column(columnDefinition="INT")
    private int id;
    @Column(columnDefinition="VARCHAR(100)")
    private String name;
    @Column(columnDefinition="VARCHAR(100)")
    private String amount;
    @Column(columnDefinition="VARCHAR(100)")
    private String allergyType;
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ingredient_recipe_id")
    @JsonIgnoreProperties(value = {"ingredients"})
    private Recipe recipe;

}
