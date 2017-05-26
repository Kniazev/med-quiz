package com.knikham.medquiz.domain;

import org.aspectj.weaver.patterns.TypePatternQuestions;

import java.util.Set;


public class Category {
    private long id;
    private String title;

    Set<Question> questions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
