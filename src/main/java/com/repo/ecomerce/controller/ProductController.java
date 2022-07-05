package com.repo.ecomerce.controller;

import com.repo.ecomerce.dto.ProductDTO;
import com.repo.ecomerce.model.Product;
import com.repo.ecomerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ecommerce/product")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

    private ProductService productService;

    @PostMapping("register-product")
    @ResponseStatus(HttpStatus.CREATED)
    public Long registerProduct(@RequestBody ProductDTO productDTO) {

       Product product = productService.registerProduct(productDTO);
       return product.getId();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);
    }

    @GetMapping("/list-products")
    public List<ProductDTO> listAll() {

      return productService.listAllProducts();
    }

    @GetMapping("/{id}/product")
    public ProductDTO findProduct(@PathVariable Long id) {

        return productService.findProduct(id);
    }
}
