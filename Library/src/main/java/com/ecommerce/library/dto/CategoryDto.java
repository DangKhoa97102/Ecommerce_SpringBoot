package com.ecommerce.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor @NoArgsConstructor

public class CategoryDto {
    private Long categoryId;
    private String categoryName;
    private Long numberOfProduct;
}
