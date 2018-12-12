package com.xmg.shopping.template;

import com.xmg.shopping.domain.Product;
import com.xmg.shopping.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTemplate {
    private void JdbcTemplate() {
    }

    public static int update(String sql, Object... parameters) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 2. 获取连接对象
            conn = JdbcUtil.getCoon();
            // 3. 创建语句对象
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < parameters.length; i++) {
                ps.setObject(i + 1, parameters[i]);
            }
            // 4. 执行sql
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 是否资源
            JdbcUtil.close(conn, ps, null);
        }
        return 0;
    }

    public static <T> T query(String sql, IResultSetHandler<T> handler, Object... parameters) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getCoon();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < parameters.length; i++) {
                ps.setObject(i + 1, parameters[i]);
            }
            // 4. 执行sql
            rs = ps.executeQuery();
            // 执行自定义处理
            return handler.handle(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn, ps, rs);
        }
        return null;
    }

}
