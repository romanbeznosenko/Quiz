package org.nonchalant.project.repositories;

import org.nonchalant.project.entities.QuestionOption;
import org.springframework.data.repository.CrudRepository;

public interface QuestionOptionRepository extends CrudRepository<QuestionOption, Long> {
}
