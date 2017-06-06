package com.knikham.medquiz.services;

import com.knikham.medquiz.AbstractTest;
import com.knikham.medquiz.domain.Answer;
import com.knikham.medquiz.domain.Category;
import com.knikham.medquiz.domain.Question;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CategoryServiceTest extends BaseServiceTest {
    @Autowired
    private ICategoryService categoryService;

    @Test
    public void testCreate() {
//        Category category = new Category();
//        category.setTitle("Cardology");
//
//        categoryService.create(category);

        List<Category> categories = categoryService.findAll();

        Assert.assertEquals(1, categories.size());

        for (Category category : categories) {
            logger.info("Body: " + category.getTitle());

            for (Question question : category.getQuestions()) {
                logger.info("QId: " + question.getId());
                logger.info("QBody: " + question.getBody());
            }
        }
    }

    @Test
    public void testDelete(){

        categoryService.delete("Cardiology");

        List<Category> categories = categoryService.findAll();

        Assert.assertEquals(0, categories.size());
    }

    @Test
    public void testFindByTitle(){

        Category found = categoryService.findCategoryByTitle("Cardiology");

        Assert.assertNotNull(found);

        logger.info("title: " + found.getTitle());
    }

    @Test
    public void testUpdate(){

        Category updatable = new Category();
        updatable.setTitle("Surgery");

        categoryService.update("Cardiology", updatable);
        Category result = categoryService.findCategoryByTitle("Surgery");

        Assert.assertEquals(updatable.getTitle(), result.getTitle());
    }
}
