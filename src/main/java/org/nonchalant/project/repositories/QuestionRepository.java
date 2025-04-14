package org.nonchalant.project.repositories;

import org.nonchalant.project.entities.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
