package org.nonchalant.project.services;

import org.nonchalant.project.entities.Question;
import org.nonchalant.project.entities.Question;
import org.nonchalant.project.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions(){
        return StreamSupport.stream(questionRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Optional<Question> updateQuestion(Long id, Question question) {
        return questionRepository.findById(id)
                .map(existingQuestion -> {
                    existingQuestion.setContent(question.getContent());
                    existingQuestion.setQuestionType(question.getQuestionType());
                    existingQuestion.setPoints(question.getPoints());
                    existingQuestion.setQuiz(question.getQuiz());
                    return questionRepository.save(existingQuestion);
                });
    }

    public boolean deleteQuestion(Long id) {
        if (questionRepository.existsById(id)) {
            questionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
