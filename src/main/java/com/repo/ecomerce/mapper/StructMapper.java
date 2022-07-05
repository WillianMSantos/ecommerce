package com.repo.ecomerce.mapper;

import com.repo.ecomerce.dto.ProductDTO;
import com.repo.ecomerce.model.Product;

public interface StructMapper {

    ProductDTO toProductDto(Product product);
    Product toProductModel(ProductDTO productDTO);
}
