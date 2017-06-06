package com.knikham.medquiz.controllers.admin;

import com.knikham.medquiz.domain.Category;
import com.knikham.medquiz.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Admin/Categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<Category>> getCategories(){

        List<Category> categories = categoryService.findAll();

        if(categories.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<Category> getCategoryByTitle(@PathVariable("title")
                                                       String title){
        if(title.isEmpty()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Category category = categoryService.findCategoryByTitle(title);

        if(category == null){
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @PostMapping("/{title}")
    public ResponseEntity<Void> createCategory(@PathVariable("title") String title){
        if(title.isEmpty()){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }

        Category category = new Category();
        category.setTitle(title);

        categoryService.create(category);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("title") String title ){
        if(title.isEmpty()){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }

        categoryService.delete(title);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/{title}/{newTitle}")
    public ResponseEntity<Void> updateCategory(@PathVariable("title") String title,
                                    @PathVariable("newTitle") String newTitle){
        if(title.isEmpty() || newTitle.isEmpty()){
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }

        Category updatable = new Category();
        updatable.setTitle(newTitle);

        categoryService.update(title, updatable);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
