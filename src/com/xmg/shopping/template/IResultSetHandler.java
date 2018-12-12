package com.xmg.shopping.template;

import java.sql.ResultSet;
import java.sql.SQLException;

// 定义处理结果集的规范, 返回的类型由用户自己定义
public interface IResultSetHandler<T> {
    T handle(ResultSet rs) throws SQLException;
}
