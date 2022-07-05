package com.repo.ecomerce.dto;

import com.repo.ecomerce.model.Category;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class ProductDTO {

    private String productName;
    private Category category;
    private BigDecimal priceProduct;
    private String operationalSystem;
    private String storage;
    private String ramMemory;
}
