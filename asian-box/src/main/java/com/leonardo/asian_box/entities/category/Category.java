package com.leonardo.asian_box.entities.category;

import com.leonardo.asian_box.DTO.CategoryDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("categories")
@Data
@NoArgsConstructor
public class Category {
    @Id
    private String id;
    private String tittle;
    private String description;
    private String ownerID;

    //Constructor for CategoryData to create a new category.
    public Category(CategoryDTO categoryDTO) {
        this.tittle = categoryDTO.title();
        this.description = categoryDTO.description();
        this.ownerID = categoryDTO.ownerID();
    }
}
