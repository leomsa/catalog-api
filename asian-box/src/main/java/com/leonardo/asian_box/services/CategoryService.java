package com.leonardo.asian_box.services;

import com.leonardo.asian_box.DTO.CategoryDTO;
import com.leonardo.asian_box.entities.category.Category;
import com.leonardo.asian_box.entities.category.exeptions.CategoryNotFoundExecption;
import com.leonardo.asian_box.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(CategoryDTO categoryData) {
        Category newCategory = new Category(categoryData);
        this.categoryRepository.save(newCategory);
        return newCategory;
    }

    public Category update(String id, CategoryDTO categoryData) {
        Category category = this.categoryRepository.findById(id).orElseThrow(CategoryNotFoundExecption::new);
        if (!categoryData.title().isEmpty()) category.setTittle(categoryData.title());
        if (!categoryData.description().isEmpty()) category.setDescription(categoryData.description());

        this.categoryRepository.save(category);

        return category;
    }

    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }
}
