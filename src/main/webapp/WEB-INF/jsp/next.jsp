<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>WELCOME TO OUR ONLINE-SHOP </title>
</head>
<body>
<div align="center">
    <h2>PRODUCTS</h2>
    <form method="get" action="search">
        <input type="text" name="keyword" />
        <input type="submit" value="Search" />
        <a href=categories/search?keyword=${keyword}"></a>
    </form>

    <table border="1" cellpadding="5">
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.productName}</td>
                <td>${product.price}</td>

                <td>
                    <button><a href="/products/open?productID=${product.productID}">OPEN</a></button>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>