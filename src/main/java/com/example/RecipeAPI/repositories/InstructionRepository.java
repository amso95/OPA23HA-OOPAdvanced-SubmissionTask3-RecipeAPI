package com.example.RecipeAPI.repositories;

import com.example.RecipeAPI.objects.Instruction;
import com.example.RecipeAPI.objects.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionRepository extends JpaRepository<Instruction, Integer> {
}
