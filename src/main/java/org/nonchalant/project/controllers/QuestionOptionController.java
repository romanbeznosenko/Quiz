package org.nonchalant.project.controllers;

import org.nonchalant.project.entities.QuestionOption;
import org.nonchalant.project.services.QuestionOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question-option")
public class QuestionOptionController {
    @Autowired
    private QuestionOptionService questionOptionService;

    @GetMapping
    public List<QuestionOption> getAllQuestionOptions(){
        return questionOptionService.getAllQuestionOptions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionOption> getQuestionOptionById(@PathVariable Long id){
        return questionOptionService.getQuestionOptionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public QuestionOption createQuestionOption(@RequestBody QuestionOption questionOption){
        return questionOptionService.addQuestionOption(questionOption);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionOption> updateQuestionOption(@PathVariable Long id, @RequestBody QuestionOption questionOption){
        return questionOptionService.updateQuestionOption(id, questionOption)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionOption(@PathVariable Long id){
        if (questionOptionService.deleteQuestionOption(id)){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
