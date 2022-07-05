package com.repo.ecomerce.mapper;

import com.repo.ecomerce.dto.ProductDTO;
import com.repo.ecomerce.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StructMapper {

    ProductDTO toProductDto(Product product);
    Product toProductModel(ProductDTO productDTO);
}
