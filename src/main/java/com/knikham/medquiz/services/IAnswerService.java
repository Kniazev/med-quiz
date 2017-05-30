package com.knikham.medquiz.services;

import com.knikham.medquiz.domain.Answer;

import java.util.Set;


public interface IAnswerService {
    void create(Long id, Answer answer);
    void update(Long id, Answer answer);
    void delete(Answer answer);

    Set<Answer> getAnswerByQuestionId(long id);
}
