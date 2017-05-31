package com.knikham.medquiz.controllers;

import com.knikham.medquiz.domain.Category;
import com.knikham.medquiz.domain.Question;
import com.knikham.medquiz.repository.IAnswerRepository;
import com.knikham.medquiz.services.IAnswerService;
import com.knikham.medquiz.services.ICategoryService;
import com.knikham.medquiz.services.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;


@RestController
public class QuizController {
    @Autowired
    ICategoryService categoryService;

    @Autowired
    IQuestionService questionService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity<Collection<Category>> getCategories(){
        Collection<Category> categories = categoryService.findAll();

        if(categories.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Collection<Category>>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/Qiuz/{title}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Question>> getQuestionByCategory(
            @PathVariable("title") String title){
        Collection<Question> questions = questionService.findByCategoryTitle(title);

        if(questions.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Collection<Question>>(questions, HttpStatus.OK);
    }
}
