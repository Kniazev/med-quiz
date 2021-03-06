package com.knikham.medquiz.repository;

import com.knikham.medquiz.domain.Category;
import com.knikham.medquiz.domain.Question;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IQuestionRepository extends JpaRepository<Question, Long>{

    List<Question> findByCategoryTitle(String title);
}
