package com.leonardo.asian_box.repositories;
import com.leonardo.asian_box.entities.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
}
