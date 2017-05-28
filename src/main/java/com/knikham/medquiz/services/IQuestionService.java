package com.knikham.medquiz.services;


import com.knikham.medquiz.domain.Question;

import java.util.List;


public interface IQuestionService {
    void create();
    void update();
    void delete();

    List<Question> findByCategoryTitle(String title);
}
