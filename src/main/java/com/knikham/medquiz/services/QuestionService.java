package com.knikham.medquiz.services;

import com.knikham.medquiz.domain.Category;
import com.knikham.medquiz.domain.Question;
import com.knikham.medquiz.repository.ICategoryRepository;
import com.knikham.medquiz.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class QuestionService implements IQuestionService {
    @Autowired
    private IQuestionRepository questionRepository;

    @Autowired
    private ICategoryService categoryService;

    @Override
    public void create(String title, Question question) {
        Category category = categoryService.findCategoryByTitle(title);

        Question created = question;
        created.setCategory(category);

        questionRepository.save(question);
    }

    @Override
    public void update(Long id, Question question) {
        Question updatable = questionRepository.getOne(id);

        updatable.setBody(question.getBody());

        questionRepository.save(updatable);
    }

    @Override
    public void delete(Long id) {
        Question question = questionRepository.findOne(id);

        questionRepository.delete(id);
    }

    @Override
    public List<Question> findByCategoryTitle(String title) {
       return questionRepository.findByCategoryTitle(title);
    }
}
