package com.repo.ecomerce.service;

import com.repo.ecomerce.dto.ProductDTO;
import com.repo.ecomerce.mapper.StructMapper;
import com.repo.ecomerce.model.Product;
import com.repo.ecomerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    private ProductRepository productRepository;
    private StructMapper structMapper;

    public Product registerProduct(ProductDTO productDTO) {

        val productToSave = structMapper.toProductModel(productDTO);
        return productRepository.save(productToSave);
    }

    public ProductDTO findProduct(Long id) {
        val product = verifyExistProduct(id);
        return structMapper.toProductDto(product);
    }

    private Product verifyExistProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Product not found"));

    }

    public void updateProduct(Long id, Product productUpdate) {
        productRepository.findById(id).map(product->{
            productUpdate.setId(product.getId());
            productRepository.save(productUpdate);
            return productUpdate;
        }).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
               "Product not found"));
    }

    public void deleteProduct(Long id) {
        productRepository.findById(id).map(product -> {

            productRepository.delete(product);
            return Void.TYPE;})
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Product not found for id"));
    }

    public List<ProductDTO> listAllProducts() {

        List<Product> allProduct = productRepository.findAll();
        return allProduct.stream()
                .map(structMapper::toProductDto)
                .collect(Collectors.toList());
    }
}
