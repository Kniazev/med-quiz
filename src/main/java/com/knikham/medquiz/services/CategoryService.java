package com.knikham.medquiz.services;

import com.knikham.medquiz.domain.Category;
import com.knikham.medquiz.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public void create(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void update(String title, Category category) {
        categoryRepository.findByTitle(title);

        categoryRepository.save(category);
    }

    @Override
    public void delete(String title) {
        Category category = categoryRepository.findByTitle(title);

        categoryRepository.delete(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }
}
