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
    <div align="right">
        <h3><a href="/new-product?categoryID=${categoryID}">ADD NEW PRODUCT</a></h3>
    </div>

    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>CategoryID</th>
            <th>Price</th>
            <th>Unit</th>
            <th>inStock</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.productID}</td>
                <td>${product.productName}</td>
                <td>${product.categoryID}</td>
                <td>${product.price}</td>
                <td>${product.unit}</td>
                <td>${product.inStock}</td>

                <td>
                    <button> <a href="/edit-product?productID=${product.productID}">Edit</a></button>
                    <button><a href="/delete-product?productID=${product.productID}">Delete</a></button>


                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>