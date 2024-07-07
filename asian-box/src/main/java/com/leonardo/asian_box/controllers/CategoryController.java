package com.leonardo.asian_box.controllers;

import com.leonardo.asian_box.DTO.CategoryDTO;
import com.leonardo.asian_box.entities.category.Category;
import com.leonardo.asian_box.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController categoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryDTO categoryData) {
         Category newCategory = this.categoryService.create(categoryData);
         return ResponseEntity.ok().body(newCategory);
    }
}
