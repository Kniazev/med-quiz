package com.knikham.medquiz.services;

import com.knikham.medquiz.domain.Answer;
import com.knikham.medquiz.domain.Question;
import com.knikham.medquiz.repository.IAnswerRepository;
import com.knikham.medquiz.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;


public class AnswerService implements IAnswerService{
    @Autowired
    private IQuestionRepository questionRepository;

    @Autowired
    private IAnswerRepository answerRepository;

    @Override
    public void create(Long id, Answer answer) {
        Question question = questionRepository.findOne(id);

        Answer createdAnswer = answer;
        createdAnswer.setQuestion(question);

        answerRepository.save(createdAnswer);
    }

    @Override
    public void update(Long id, Answer answer) {
        Answer updatable = answerRepository.getOne(id);
        updatable.setBody(answer.getBody());
        updatable.setRight(answer.isRight());
        updatable.setQuestion(answer.getQuestion());

        answerRepository.save(updatable);
    }

    @Override
    public void delete(Answer answer) {

    }

    @Override
    public Set<Answer> getAnswerByQuestionId(long id) {
        return null;
    }
}
