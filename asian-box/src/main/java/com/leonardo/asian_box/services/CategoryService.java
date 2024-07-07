package com.leonardo.asian_box.services;

import com.leonardo.asian_box.DTO.CategoryDTO;
import com.leonardo.asian_box.entities.category.Category;
import com.leonardo.asian_box.entities.category.exeptions.CategoryNotFoundExecption;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private com.leonardo.asian_box.repositories.CategoryService categoryRepository;

    public CategoryService(com.leonardo.asian_box.repositories.CategoryService categoryRepository) {
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

    public void delete(String id) {
      Category category = this.categoryRepository.findById(id)
              .orElseThrow(CategoryNotFoundExecption::new);

        this.categoryRepository.delete(category);
    }

    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    public Optional<Category> getById(String id) {
        return this.categoryRepository.findById(id);
    }
}
