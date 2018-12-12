<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--jsp 核心标签库--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>helloworld</title>
</head>
<body>

<%--跳转到添加商品界面，但是这里不能够直接跳过去，所有我们先跳转给servlet来处理--%>
<a href="/product?cmd=edit">添加商品</a>
<table border="1" cellpadding="0" cellspacing="0" width="90%">
    <tr style="background-color: orange">
        <th>货品编号</th>
        <th>货品名称</th>
        <th>货品品牌</th>
        <th>货品分类</th>
        <th>供应商</th>
        <th>零&nbsp;售&nbsp;价</th>
        <th>成&nbsp;本&nbsp;价</th>
        <th>折&emsp;&emsp;扣</th>
        <th>操&emsp;&emsp;作</th>
    </tr>

    <c:forEach items="${products}" var="p" >
        <tr>
            <td>${p.id}</td>
            <td>${p.productName}</td>
            <td>${p.brand}</td>
            <td>${p.dir_id}</td>
            <td>${p.supplier}</td>
            <td>${p.salePrice}</td>
            <td>${p.costPrice}</td>
            <td>${p.cutoff}</td>
            <td><a href="/product?cmd=edit&id=${p.id}">编辑</a> | <a href="/product?cmd=delete&id=${p.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
