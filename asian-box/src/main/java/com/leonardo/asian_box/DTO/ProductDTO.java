package com.leonardo.asian_box.DTO;

import org.bson.types.Decimal128;

public record ProductDTO(String title, String description, String ownerID, Decimal128 price, String categoryID) {
}
