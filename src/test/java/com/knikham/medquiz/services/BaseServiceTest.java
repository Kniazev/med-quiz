package com.knikham.medquiz.services;

import com.knikham.medquiz.AbstractTest;
import com.knikham.medquiz.domain.Answer;
import com.knikham.medquiz.domain.Category;
import com.knikham.medquiz.domain.Question;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.HashSet;
import java.util.Set;


public class BaseServiceTest extends AbstractTest {
    @Autowired
    private IAnswerService answerService;

    @Autowired
    private IQuestionService questionService;

    @Autowired
    private ICategoryService categoryService;

    @Before
    @Rollback(false)
    public void setUp(){
        categoryService.deleteAll();
        questionService.deleteAll();

        Category category = new Category();
        category.setTitle("Cardiology");

        categoryService.create(category);

        Answer answer1 = new Answer();
        answer1.setBody("Body of answer one");
        answer1.setRight(true);

        Answer answer2 = new Answer();
        answer1.setBody("Body of answer two");
        answer1.setRight(false);

        Answer answer3 = new Answer();
        answer1.setBody("Body of answer three");
        answer1.setRight(false);

        Set<Answer> answers = new HashSet<>();

        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);

        Question question1 = new Question();
        question1.setCategory(category);
        question1.setBody("Body of question one");
        question1.setAnswers(answers);

        Question question2 = new Question();
        question2.setCategory(category);
        question2.setBody("Body of question two");
        question2.setAnswers(answers);

        questionService.create(category.getTitle(), question1);
        questionService.create(category.getTitle(), question2);
    }
}
