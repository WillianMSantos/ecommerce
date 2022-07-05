package com.repo.ecomerce.mapper;
import com.repo.ecomerce.dto.ProductDTO;
import com.repo.ecomerce.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductMapper implements StructMapper {

    @Override
    @Transactional
    public ProductDTO toProductDto(Product product){

        return ProductDTO.builder()
                .productName(product.getProductName())
                .category(product.getCategory())
                .priceProduct(product.getPriceProduct())
                .operationalSystem(product.getOperationalSystem())
                .storage(product.getStorage())
                .ramMemory(product.getRamMemory()).build();

    }

    @Override
    @Transactional
    public Product toProductModel(ProductDTO productDTO) {
        return Product.builder()
                .productName(productDTO.getProductName())
                .category(productDTO.getCategory())
                .priceProduct(productDTO.getPriceProduct())
                .operationalSystem(productDTO.getOperationalSystem())
                .storage(productDTO.getStorage())
                .ramMemory(productDTO.getRamMemory()).build();
    }
}
