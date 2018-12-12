package com.xmg.shopping.dao.impl;


import com.xmg.shopping.dao.IProductDirDao;
import com.xmg.shopping.domain.ProductDir;
import com.xmg.shopping.template.IResultSetHandler;
import com.xmg.shopping.template.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDirDaoImpl implements IProductDirDao {

    @Override
    public void save(ProductDir obj) {
        String sql = "INSERT INTO productDir (dirName, parentId) VALUES (?,?)";
        JdbcTemplate.update(sql,obj.getDirName(), obj.getParentId());
    }

    @Override
    public void update(ProductDir obj) {
        String sql = "UPDATE productDir SET dirName = ?, parentId = ? WHERE id = ?";
        JdbcTemplate.update(sql,obj.getDirName(), obj.getParentId(),obj.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM productDir WHERE id = ?";
        JdbcTemplate.update(sql,id);
    }

    @Override
    public ProductDir get(Long id) {
        String sql = "SELECT * FROM productDir WHERE id = ?";
        return JdbcTemplate.query(sql, new IResultSetHandler<ProductDir>() {
            @Override
            public ProductDir handle(ResultSet rs) throws SQLException {
                if (rs.next()) {
                    ProductDir dir = new ProductDir();
                    dir.setId(rs.getLong("id"));
                    dir.setDirName(rs.getString("dirName"));
                    dir.setParentId(rs.getLong("parentId"));
                    return dir;
                }
                return null;
            }
        }, id);
    }

    @Override
    public List<ProductDir> list() {
        String sql = "SELECT * FROM productDir";
        return JdbcTemplate.query(sql, new IResultSetHandler<List<ProductDir>>() {
            @Override
            public List<ProductDir> handle(ResultSet rs) throws SQLException {
                List<ProductDir> list = new ArrayList<>();
                while (rs.next()) {
                    ProductDir dir = new ProductDir();
                    dir.setId(rs.getLong("id"));
                    dir.setDirName(rs.getString("dirName"));
                    dir.setParentId(rs.getLong("parentId"));
                    list.add(dir);
                }
                return list;
            }
        });
    }
}
