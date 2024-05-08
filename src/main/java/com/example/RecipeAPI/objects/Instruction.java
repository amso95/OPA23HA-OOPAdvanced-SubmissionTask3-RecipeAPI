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
@Table(name = "instruction_table")
public class Instruction {
    @Id
    @Column(columnDefinition="INT")
    private int id;
    @Column(columnDefinition="TEXT")
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "instruction_recipe_id")
    @JsonIgnoreProperties(value = {"instructions"})
    private Recipe recipe;
}
