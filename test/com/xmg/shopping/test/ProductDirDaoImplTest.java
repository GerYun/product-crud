package com.xmg.shopping.test;

import com.xmg.shopping.dao.IProductDirDao;
import com.xmg.shopping.dao.impl.ProductDirDaoImpl;
import com.xmg.shopping.domain.ProductDir;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProductDirDaoImplTest {

    IProductDirDao dao = new ProductDirDaoImpl();
    @Test
    public void list() {
        List<ProductDir> list = dao.list();
        System.out.println("list = " + list);
    }
}