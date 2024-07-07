package com.leonardo.asian_box.services;

import com.leonardo.asian_box.DTO.CategoryDTO;
import com.leonardo.asian_box.DTO.ProductDTO;
import com.leonardo.asian_box.entities.category.Category;
import com.leonardo.asian_box.entities.category.exeptions.CategoryNotFoundExecption;
import com.leonardo.asian_box.entities.product.Product;
import com.leonardo.asian_box.repositories.CategoryService;
import com.leonardo.asian_box.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    private CategoryService categoryService;


    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public Product create(ProductDTO productData) {
        Product newProduct = new Product(productData);
        this.productRepository.save(newProduct);
        return newProduct;
    }

    public Product update(String id, CategoryDTO categoryData) {
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

    public List<Product> getAll() {
        return this.productRepository.findAll();
    }
}
