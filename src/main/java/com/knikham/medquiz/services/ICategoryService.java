package com.knikham.medquiz.services;

import com.knikham.medquiz.domain.Category;

import java.util.List;


public interface ICategoryService {
    void create();
    void update();
    void delete();
    List<Category> findAll();
    Category findCategoryByTitle(String title);
}
