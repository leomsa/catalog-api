package com.leonardo.asian_box.entities.category;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
}
