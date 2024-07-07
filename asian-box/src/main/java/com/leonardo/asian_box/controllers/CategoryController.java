package com.leonardo.asian_box.controllers;

import com.leonardo.asian_box.DTO.CategoryDTO;
import com.leonardo.asian_box.entities.category.Category;
import com.leonardo.asian_box.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryDTO categoryData) {
         Category newCategory = this.categoryService.create(categoryData);
         return ResponseEntity.ok().body(newCategory);
    }

    @GetMapping
    public  ResponseEntity<List<Category>> getAll() {
        List<Category> categories = this.categoryService.getAll();
        return ResponseEntity.ok().body(categories);
    }
}
