package com.knikham.medquiz.services;


import com.knikham.medquiz.domain.Question;

import java.util.List;


public interface IQuestionService {
    void create(String title, Question question);
    void update(Long id, Question question);
    void delete(Long id);
    Question findOne(Long id);

    List<Question> findByCategoryTitle(String title);
}
