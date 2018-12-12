package com.xmg.shopping.dao.impl;

import com.xmg.shopping.dao.IProductDao;
import com.xmg.shopping.domain.Product;
import com.xmg.shopping.template.IResultSetHandler;
import com.xmg.shopping.template.JdbcTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements IProductDao {

    // 贾连浴执使
    @Override
    public void save(Product obj) {

        String sql = "INSERT INTO product (productName, brand, supplier, salePrice, costPrice, cutoff, dir_id) values (?,?,?,?,?,?,?)";
        JdbcTemplate.update(sql, obj.getProductName(), obj.getBrand(), obj.getSupplier(), obj.getSalePrice(), obj.getCostPrice(), obj.getCutoff(), obj.getDir_id());
    }

    @Override
    public void update(Product obj) {

        String sql = "UPDATE product SET productName = ?, brand = ?, supplier = ?, salePrice = ?, costPrice = ?, cutoff = ?, dir_id = ? WHERE id = ?";
        JdbcTemplate.update(sql, obj.getProductName(), obj.getBrand(), obj.getSupplier(), obj.getSalePrice(), obj.getCostPrice(), obj.getCutoff(), obj.getDir_id(), obj.getId());
    }

    @Override
    public void delete(Long id) {

        String sql = "DELETE FROM product WHERE id = ?";
        JdbcTemplate.update(sql, id);
    }

    // 贾连浴执释
    @Override
    public Product get(Long id) {

        String sql = "SELECT * FROM product WHERE id = ?";
        return JdbcTemplate.query(sql, new IResultSetHandler<Product>() {
            @Override
            public Product handle(ResultSet rs) throws SQLException {
                if (rs.next()) {
                    Product pd = new Product();
                    pd.setId(rs.getLong("id"));
                    pd.setProductName(rs.getString("productName"));
                    pd.setBrand(rs.getString("brand"));
                    pd.setSupplier(rs.getString("supplier"));
                    pd.setSalePrice(rs.getBigDecimal("salePrice"));
                    pd.setCostPrice(rs.getBigDecimal("costPrice"));
                    pd.setCutoff(rs.getDouble("cutoff"));
                    pd.setDir_id(rs.getLong("dir_id"));
                    return pd;
                }
                return null;
            }
        }, id);
    }

    @Override
    public List<Product> list() {
        String sql = "SELECT * FROM product";
        return JdbcTemplate.query(sql, new ProductResultSetHandler());
    }

    class ProductResultSetHandler implements IResultSetHandler<List<Product>> {

        @Override
        public List<Product> handle(ResultSet rs) throws SQLException {
            List<Product> list = new ArrayList<>();
            while (rs.next()) {
                Product pd = new Product();
                pd.setId(rs.getLong("id"));
                pd.setProductName(rs.getString("productName"));
                pd.setBrand(rs.getString("brand"));
                pd.setSupplier(rs.getString("supplier"));
                pd.setSalePrice(rs.getBigDecimal("salePrice"));
                pd.setCostPrice(rs.getBigDecimal("costPrice"));
                pd.setCutoff(rs.getDouble("cutoff"));
                pd.setDir_id(rs.getLong("dir_id"));
                list.add(pd);
            }
            return list;
        }
    }
}
