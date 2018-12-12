package com.xmg.shopping.test;

import com.xmg.shopping.dao.IProductDao;
import com.xmg.shopping.dao.impl.ProductDaoImpl;
import com.xmg.shopping.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductDaoImplTest {

    IProductDao dao = new ProductDaoImpl();

    @org.junit.Test
    public void save() {
        Product pd = new Product();
        pd.setProductName("盘个股");
        pd.setBrand("啦啦");
        pd.setSupplier("史蒂夫");
        pd.setSalePrice(new BigDecimal(549.00));
        pd.setCostPrice(new BigDecimal(30));
        pd.setCutoff(0.9);
        pd.setDir_id(2L);
        dao.save(pd);
    }

    @org.junit.Test
    public void update() {

        Product pd = new Product();
        pd.setProductName("小鸡儿");
        pd.setBrand("华为");
        pd.setSupplier("华为");
        pd.setSalePrice(new BigDecimal(549.00));
        pd.setCostPrice(new BigDecimal(30));
        pd.setCutoff(0.9);
        pd.setDir_id(5L);
        // 更新的id
        pd.setId(5L);
        dao.update(pd);
    }

    @org.junit.Test
    public void delete() {
        dao.delete(1L);
    }

    @org.junit.Test
    public void get() {
        Product pd = dao.get(2L);
        System.out.println(pd);
    }

    @org.junit.Test
    public void list() {
        List<Product> list = dao.list();
        System.out.println(list);
    }
}