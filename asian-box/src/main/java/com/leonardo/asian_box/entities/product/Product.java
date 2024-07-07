package com.leonardo.asian_box.entities.product;

import com.leonardo.asian_box.DTO.ProductDTO;
import com.leonardo.asian_box.entities.category.Category;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Decimal128;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String title;
    private String description;
    private String ownerID;
    private Decimal128 price;
    private Category category;

    public Product(ProductDTO productDTO) {
        this.title = productDTO.title();
        this.description = productDTO.description();
        this.ownerID = productDTO.ownerID();
        this.price = productDTO.price();
    }
}
