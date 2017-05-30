package com.knikham.medquiz.repository;

import com.knikham.medquiz.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;


public interface IAnswerRepository extends JpaRepository<Answer, Long> {

    Set<Answer> getAnswerByQuestionId(long id);
}
