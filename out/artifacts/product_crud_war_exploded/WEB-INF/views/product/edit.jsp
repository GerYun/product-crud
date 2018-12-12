<%--
  Created by IntelliJ IDEA.
  User: weiwudu
  Date: 2018/12/11
  Time: 9:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>

<form action="/product?cmd=update" method="post">
    <input type="hidden" value="${product.id}" name="id"/>
    <table>
        <tr>
            <td>货品分类</td>
            <td><input type="text" name="productName" value="${product.productName}"/></td>
        </tr>
        <tr>
            <td>货品品牌</td>
            <td><input type="text" name="brand" value="${product.brand}"/></td>
        </tr>
        <tr>
            <td>供&nbsp;应&nbsp;商</td>
            <td><input type="text" name="supplier" value="${product.supplier}"/></td>
        </tr>
        <tr>
            <td>零&nbsp;售&nbsp;价</td>
            <td><input type="number" name="salePrice" value="${product.salePrice}"/></td>
        </tr>
        <tr>
            <td>成&nbsp;本&nbsp;价</td>
            <td><input type="number" name="costPrice" value="${product.costPrice}"/></td>
        </tr>
        <tr>
            <td>折&nbsp;扣&nbsp;价</td>
            <td><input type="text" name="cutoff" value="${product.cutoff}"/></td>
        </tr>
        <tr>
            <td>商品分类</td>
            <td>
                <select name="dir">
                    <c:forEach items="${dirs}" var="dir">
                        <option value="${dir.id}" ${product.dir_id == dir.id ? "selected" : ""}>${dir.dirName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>
    <input type="submit" value="${product.id == null ? "保存" : "更新"}"/>
</form>

</body>
</html>
