package com.repo.ecomerce.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "TB_PRODUCT")
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "CATEGORY")
    private Category category;

    @Column(name = "PRICE_PRODUCT")
    private BigDecimal priceProduct;

    @Column(name = "OPERATION_SYSTEM")
    private String operationalSystem;

    @Column(name = "STORAGE")
    private String storage;

    @Column(name = "RAM_MEMORY")
    private String ramMemory;
}
