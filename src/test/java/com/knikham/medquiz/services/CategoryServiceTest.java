package com.knikham.medquiz.services;

import com.knikham.medquiz.AbstractTest;
import com.knikham.medquiz.domain.Category;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CategoryServiceTest extends AbstractTest {
    @Autowired
    private ICategoryService categoryService;

    @Test
    public void testCreate(){
        Category category = new Category();
        category.setTitle("Cardology");

        categoryService.create(category);

        List<Category> categories = categoryService.findAll();

        Assert.assertEquals(1,categories.size());
    }

    @Test
    public void testDelete(){
        Category category = new Category();
        category.setTitle("Cardiology");

        categoryService.create(category);

        categoryService.delete("Cardiology");

        List<Category> categories = categoryService.findAll();

        Assert.assertEquals(0, categories.size());
    }

    @Test
    public void testFindByTitle(){
        Category category = new Category();
        category.setTitle("Cardiology");

        categoryService.create(category);

        Category found = categoryService.findCategoryByTitle("Cardiology");

        Assert.assertNotNull(found);
    }

    @Test
    public void testUpdate(){
        Category first = new Category();
        first.setTitle("Cardio");

        categoryService.create(first);

        Category updatable = new Category();
        updatable.setTitle("Cardiology");

        categoryService.update("Cardio", updatable);
        Category result = categoryService.findCategoryByTitle("Cardiology");

        Assert.assertEquals(updatable.getTitle(), result.getTitle());
    }
}
