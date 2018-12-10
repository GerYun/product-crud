package com.xmg.shopping.dao;

import com.xmg.shopping.domain.Product;

import java.util.List;

public interface IProductDao {

    public void save(Product obj);

    public void update(Product obj);

    public void delete(Long id);

    public Product get(Long id);

    public List<Product> list();
}
