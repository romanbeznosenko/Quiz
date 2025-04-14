package org.nonchalant.project.repositories;

import org.nonchalant.project.entities.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz, Long> {
}
