package com.example.RecipeAPI.controllers;

import com.example.RecipeAPI.objects.Instruction;
import com.example.RecipeAPI.objects.Recipe;
import com.example.RecipeAPI.services.InstructionService;
import com.example.RecipeAPI.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instruction")
@CrossOrigin(origins = "*")
public class InstructionController {
    private InstructionService instructionService;

    public InstructionController(InstructionService instructionService){
        this.instructionService = instructionService;
    }

    // Get mapping to get a list of BlogPost objects.
    @GetMapping("/get-all")
    public List<Instruction> getAllBlogPosts() {
        return instructionService.getAllInstructions();
    }

    @GetMapping("/get-next-id")
    public int getNextInstructionId() {
        return instructionService.getNextId();
    }
    @PostMapping("/create")
    public ResponseEntity<String> createNewBlogPost(@RequestBody Instruction instruction){
            // Check if addInstruction successes or not.
            boolean success = instructionService.addInstruction(instruction);
            if(success) {
                // Post request succeeded.
                return ResponseEntity.status(HttpStatus.CREATED).body("Added successfully");
            }
            // Post request failed.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add recipe");
    }
    @PutMapping("/edit")
    public ResponseEntity<String> editRecipe(@RequestBody Instruction instruction){
        // Check if updateInstruction successes or not.
        boolean success = instructionService.updateInstruction(instruction);
        if(success) {
            // Put request succeeded.
            return ResponseEntity.status(HttpStatus.OK).body("Edited successfully");
        }
        // Put request failed.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to edit instruction");
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteRecipeById(int id) {
        // Check if deleteInstructionById successes or not.
        boolean success = instructionService.deleteInstructionById(id);
        if (success) {
            // Delete request succeeded.
            return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully") ;
        }
        // Delete request failed.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to deleted instruction");
    }

}
