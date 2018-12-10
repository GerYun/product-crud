package com.xmg.shopping.dao.impl;

import com.xmg.shopping.dao.IProductDao;
import com.xmg.shopping.domain.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements IProductDao {

    // 贾连浴执使
    @Override
    public void save(Product obj) {

        String sql = "INSERT INTO product (productName, brand, supplier, salePrice, costPrice, cutoff, dir_id) values (?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1. 加载注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///jdbcdemo", "root", "123123123");
            // 3. 创建语句对象
            ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getProductName());
            ps.setString(2, obj.getBrand());
            ps.setString(3, obj.getSupplier());
            ps.setBigDecimal(4, obj.getSalePrice());
            ps.setBigDecimal(5, obj.getCostPrice());
            ps.setDouble(6, obj.getCutoff());
            ps.setLong(7, obj.getDir_id());
            // 4. 执行sql
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 是否资源
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Product obj) {

        String sql = "UPDATE product SET productName = ?, brand = ?, supplier = ?, salePrice = ?, costPrice = ?, cutoff = ?, dir_id = ? WHERE id = ?";
            Connection conn = null;
            PreparedStatement ps = null;
            try {
                // 1. 加载注册驱动
                Class.forName("com.mysql.cj.jdbc.Driver");
                // 2. 获取连接对象
                conn = DriverManager.getConnection("jdbc:mysql:///jdbcdemo", "root", "123123123");
                // 3. 创建语句对象
                ps = conn.prepareStatement(sql);
                ps.setString(1, obj.getProductName());
                ps.setString(2, obj.getBrand());
                ps.setString(3, obj.getSupplier());
                ps.setBigDecimal(4, obj.getSalePrice());
                ps.setBigDecimal(5, obj.getCostPrice());
                ps.setDouble(6, obj.getCutoff());
                ps.setLong(7, obj.getDir_id());
                ps.setLong(8, obj.getId());
                // 4. 执行sql
                ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 是否资源
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(Long id) {

        String sql = "DELETE FROM product WHERE id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1. 加载注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///jdbcdemo", "root", "123123123");
            // 3. 创建语句对象
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            // 4. 执行sql
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 是否资源
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 贾连浴执释
    @Override
    public Product get(Long id) {

        String sql = "SELECT * FROM product WHERE id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1. 加载注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///jdbcdemo", "root", "123123123");
            // 3. 创建语句对象
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            // 4. 执行sql
            rs = ps.executeQuery();

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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 是否资源
            try {

                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                try {
                    if (ps != null) {
                        ps.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public List<Product> list() {
        String sql = "SELECT * FROM product";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1. 加载注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///jdbcdemo", "root", "123123123");
            // 3. 创建语句对象
            ps = conn.prepareStatement(sql);
            // 4. 执行sql
            rs = ps.executeQuery();
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 是否资源
            try {

                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                try {
                    if (ps != null) {
                        ps.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }
}
