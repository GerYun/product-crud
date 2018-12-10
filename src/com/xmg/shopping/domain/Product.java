package com.xmg.shopping.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private Long id;
    private String productName;
    private String brand;
    private String supplier;
    private BigDecimal salePrice; // 零售价
    private BigDecimal costPrice; // 成本价
    private Double cutoff;      // 折扣
    private Long dir_id;         // 分类id
}
