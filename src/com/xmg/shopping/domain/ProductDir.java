package com.xmg.shopping.domain;

import lombok.Data;

@Data
public class ProductDir {
    private Long id;
    private String dirName;
    private Long parentId;
}
