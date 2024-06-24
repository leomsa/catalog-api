package com.leonardo.asian_box.repositories;

import com.leonardo.asian_box.entities.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository <Category, String> {
}
