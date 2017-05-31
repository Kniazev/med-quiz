package com.knikham.medquiz.model;

import java.util.List;


public class QuizModel {
    private String body;
    private List<AnswerModel> answerModels;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<AnswerModel> getAnswerModels() {
        return answerModels;
    }

    public void setAnswerModels(List<AnswerModel> answerModels) {
        this.answerModels = answerModels;
    }
}
