package org.nonchalant.project.repositories;

import org.nonchalant.project.entities.Submission;
import org.springframework.data.repository.CrudRepository;

public interface SubmissionRepository extends CrudRepository<Submission, Long> {
}
