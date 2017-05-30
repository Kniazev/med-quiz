package com.knikham.medquiz.services;

import com.knikham.medquiz.AbstractTest;
import com.knikham.medquiz.domain.Answer;
import com.knikham.medquiz.domain.Category;
import com.knikham.medquiz.domain.Question;
import com.knikham.medquiz.repository.IQuestionRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Transactional
public class QuestionServiceTest extends AbstractTest {
    @Autowired
    private IAnswerService answerService;

    @Autowired
    private IQuestionService questionService;

    @Autowired
    private ICategoryService categoryService;

    @Before
    @Rollback(false)
    public void setUp(){
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

    @Test
    public void testFindByCategory(){
        List<Question> questions = questionService.findByCategoryTitle("Cardiology");

        Assert.assertNotNull(questions);
        Assert.assertEquals(2, questions.size());
    }

    @Test
    public void testCreate(){
        Category category = categoryService.findCategoryByTitle("Cardiology");

        Question question3 = new Question();
        question3.setBody("Body of question three");

        questionService.create(category.getTitle(), question3);

        List<Question> questions = questionService.findByCategoryTitle("Cardiology");

        for (Question question: questions) {
            logger.info("Body: " + question.getBody());
            logger.info("Id: " + question.getId());
        }

        Assert.assertEquals(3, questions.size());
    }

    @Test
    public void testDelete(){
        questionService.delete(new Long(2));

        List<Question> questions = questionService.findByCategoryTitle("Cardiology");

        for (Question question: questions) {
            logger.info("Body: " + question.getBody());
            logger.info("Id: " + question.getId());
        }

        Assert.assertEquals(1, questions.size());
    }

    @Test
    public void testUpdate(){
        Category category = new Category();
        category.setTitle("Cardiology");

        Question question = new Question();
        //question.setCategory(category);
        question.setBody("Updated body");

        Answer answer = new Answer();
        answer.setBody("Body for updated question.");

        questionService.update(2L, question);
    }
}
