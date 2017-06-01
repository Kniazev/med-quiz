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
public class QuestionServiceTest extends BaseServiceTest {
    @Autowired
    private IAnswerService answerService;

    @Autowired
    private IQuestionService questionService;

    @Autowired
    private ICategoryService categoryService;

    @Test
    public void testFindByCategory(){
        List<Question> questions = questionService.findByCategoryTitle("Cardiology");

        Assert.assertNotNull(questions);
        Assert.assertEquals(2, questions.size());

        for (Question question: questions) {
            logger.info("Body: " + question.getBody());
            logger.info("Id: " + question.getId());
        }
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
        List<Question> questionsBefore = questionService.findByCategoryTitle("Cardiology");

        for (Question question: questionsBefore) {
            logger.info("Body: " + question.getBody());
            logger.info("Id: " + question.getId());
        }

        questionService.delete(6L);

        List<Question> questionsAfterDelete = questionService.findByCategoryTitle("Cardiology");

        for (Question question: questionsAfterDelete) {
            logger.info("Body: " + question.getBody());
            logger.info("Id: " + question.getId());
        }

        Assert.assertEquals(1, questionsAfterDelete.size());
    }

    @Test
    public void testUpdate(){
        List<Question> questionsBefore = questionService.findByCategoryTitle("Cardiology");

        for (Question question: questionsBefore) {
            logger.info("Body: " + question.getBody());
            logger.info("Id: " + question.getId());
        }

        Question question = new Question();
        question.setBody("Updated body");

        Answer answer = new Answer();
        answer.setBody("Body for updated question.");

        questionService.update(9L, question);

        Question afterUpdateQuestion = questionService.findOne(9L);

        logger.info("updated body: " + afterUpdateQuestion.getBody());
        logger.info(afterUpdateQuestion.getCategory().getTitle());
    }
}
