package com.leonardo.asian_box.entities.product;

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
    private String tittle;
    private String ownerID;
    private String description;
    private Decimal128 price;
    private Category category;
}
