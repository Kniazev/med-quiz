package com.knikham.medquiz.services;

import com.knikham.medquiz.domain.Answer;

import java.util.Set;


public interface IAnswerQuestion {
    void create();
    void update();
    void delete();

    Set<Answer> getAnswerByQuestionId(long id);
}
