package com.xmg.shopping.dao;

import com.xmg.shopping.domain.Product;
import com.xmg.shopping.domain.ProductDir;

import java.util.List;

public interface IProductDirDao {

    public void save(ProductDir obj);

    public void update(ProductDir obj);

    public void delete(Long id);

    public ProductDir get(Long id);

    public List<ProductDir> list();
}
