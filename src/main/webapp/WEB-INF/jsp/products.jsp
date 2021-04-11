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
    <h3> ${message}</h3>
</div>

<div align="center">
    <h2>ALL PRODUCTS</h2>
    <form method="get" action="search">
        <input type="text" name="keyword" />
        <input type="submit" value="Search" />
        <a href=/search?keyword=${keyword}"></a>
    </form>
    <div align="left">
        <h3><a href="/new-client">MAKE ORDER</a></h3>
    </div>
    <div align="left">
        <h4><a href="/confirmation?orderID=${orderID}">CONFIRM THE ORDER</a></h4>
    </div>
    <h3><a href="/categories?orderID=${orderID}">See all categories</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${productDTOList}" var="product">
            <tr>
                <td>${product.productName}</td>
                <td>${product.price}</td>

                <td>
                   <button><a href="/products/open?orderID=${orderID}&productID=${product.productID}">OPEN</a></button>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>