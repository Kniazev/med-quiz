package com.knikham.medquiz.repository;

import com.knikham.medquiz.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICategoryRepository extends JpaRepository<Category, Long> {

    Category findByTitle(String title);
}
