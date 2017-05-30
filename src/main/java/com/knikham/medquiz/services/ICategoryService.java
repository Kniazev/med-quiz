package com.knikham.medquiz.services;

import com.knikham.medquiz.domain.Category;

import java.util.List;


public interface ICategoryService {
    void create(Category category);
    void update(String title, Category category);
    void delete(String title);
    List<Category> findAll();
    Category findCategoryByTitle(String title);
}
