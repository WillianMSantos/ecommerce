package com.repo.ecomerce.service;

import com.repo.ecomerce.dto.ProductDTO;
import com.repo.ecomerce.mapper.StructMapper;
import com.repo.ecomerce.model.Product;
import com.repo.ecomerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    private ProductRepository productRepository;
    private StructMapper structMapper;

    public Product registerProduct(ProductDTO productDTO) {

        Product productToSave = structMapper.toProductModel(productDTO);
        return productRepository.save(productToSave);
    }


    public List<ProductDTO> listAllProducts(){

        List<Product> allProduct = productRepository.findAll();
        return allProduct.stream()
                .map(structMapper::toProductDto)
                .collect(Collectors.toList());
    }
}
