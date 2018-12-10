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
        pd.setProductName("小啦哥鼠标");
        pd.setBrand("罗技");
        pd.setSupplier("罗技");
        pd.setSalePrice(new BigDecimal(549.00));
        pd.setCostPrice(new BigDecimal(30));
        pd.setCutoff(0.79);
        pd.setDir_id(2L);
        dao.save(pd);
    }

    @org.junit.Test
    public void update() {

        Product pd = new Product();
        pd.setProductName("华为电脑");
        pd.setBrand("华为");
        pd.setSupplier("华为");
        pd.setSalePrice(new BigDecimal(549.00));
        pd.setCostPrice(new BigDecimal(30));
        pd.setCutoff(0.69);
        pd.setDir_id(4L);
        // 更新的id
        pd.setId(2L);
        dao.update(pd);
    }

    @org.junit.Test
    public void delete() {
        dao.delete(1L);
    }

    @org.junit.Test
    public void get() {
        Product pd = dao.get(1L);
        System.out.println(pd);
    }

    @org.junit.Test
    public void list() {
        List<Product> list = dao.list();
        System.out.println(list);
    }
}