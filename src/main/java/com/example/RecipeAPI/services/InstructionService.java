package com.example.RecipeAPI.services;

import com.example.RecipeAPI.objects.Instruction;
import com.example.RecipeAPI.repositories.InstructionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InstructionService {
    private InstructionRepository repo;

    public InstructionService(InstructionRepository instructionRepository){
        this.repo = instructionRepository;
    }

    public ArrayList<Instruction> getAllInstructions(){
        return (ArrayList<Instruction>) repo.findAll();
    }

    public  int getNextId(){
        return repo.findAll().getLast().getId() + 1;
    }
    public boolean addInstruction(Instruction instruction) {
        Instruction newInstruction = repo.save(instruction);
        instruction.setId(newInstruction.getId());
        return true;
    }

    public boolean updateInstruction(Instruction instruction) {
        if(repo.existsById(instruction.getId())){
            repo.save(instruction);
            return true;
        }
        return false;
    }

    public boolean deleteInstructionById(int id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
