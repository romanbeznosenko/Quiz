package org.nonchalant.project.services;

import org.nonchalant.project.entities.Question;
import org.nonchalant.project.entities.QuestionOption;
import org.nonchalant.project.repositories.QuestionOptionRepository;
import org.nonchalant.project.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class QuestionOptionService {
    @Autowired
    private QuestionOptionRepository questionOptionRepository;

    public List<QuestionOption> getAllQuestionOptions(){
        return StreamSupport.stream(questionOptionRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<QuestionOption> getQuestionOptionById(Long id){
        return questionOptionRepository.findById(id);
    }

    public QuestionOption addQuestionOption(QuestionOption questionOption){
        return questionOptionRepository.save(questionOption);
    }

    public Optional<QuestionOption> updateQuestionOption(Long id, QuestionOption questionOption){
        return questionOptionRepository.findById(id)
                .map(existingQuestionOption -> {
                    existingQuestionOption.setQuestion(questionOption.getQuestion());
                    existingQuestionOption.setContent(questionOption.getContent());
                    existingQuestionOption.setCorrect(questionOption.getCorrect());
                    return questionOptionRepository.save(questionOption);
                });
    }

    public boolean deleteQuestionOption(Long id){
        if (questionOptionRepository.existsById(id)){
            questionOptionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
