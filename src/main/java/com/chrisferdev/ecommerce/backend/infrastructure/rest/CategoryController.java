package com.chrisferdev.ecommerce.backend.infrastructure.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chrisferdev.ecommerce.backend.application.CategoryService;
import com.chrisferdev.ecommerce.backend.domain.model.Category;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/admin/categories")
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }

    @GetMapping
    public Iterable<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Integer id){
        return categoryService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        categoryService.deleteById(id);
    }

}
