<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>PRODUCT</title>
    <style>
        .error {
            color: red; font-weight: bold;
        }
    </style>
</head>
<body>
<div align="center">
    <h2>INFORMATION OF PRODUCT</h2>
    <div align="left">
        <h4><a href="/confirmation?orderID=${orderID}">CONFIRM THE ORDER</a></h4>
    </div>
    <form action="/buy" method="post">
    <table border="2" cellpadding="7">
        <tr>


        </tr>

            <tr>
                <td>Category</td>
                <td><input type="text" name="categoryID" value="<c:out value= '${productDTO.category.categoryID}' />"/></td>
            </tr>
        <tr>
            <td>Category</td>
            <td><input type="text" name="categoryName" value="<c:out value= '${productDTO.category.categoryName}' />"/></td>
        </tr>
        <tr>
            <td>Category</td>
            <td><input type="text" name="description" value="<c:out value= '${productDTO.category.description}' />"/></td>
        </tr>
        <tr>
            <td>ID</td>
            <td><input type="text" name="productID" value="<c:out value= '${productDTO.productID}' />"/></td>
        </tr>
               <tr>
                   <td>Name</td>
                   <td><input type="text" name="productName" value="<c:out value= '${productDTO.productName}' />"/></td>
               </tr>
        <tr>
            <td>Price</td>
                <td> <input type="text" name="price" value="<c:out value= '${productDTO.price}' />"/></td>
        </tr>
        <tr>
            <td>Unit</td>
            <td> <input type="text" name="unit" value="<c:out value= '${productDTO.unit}' />"/></td>
        </tr>
        <tr>

            <td> <input type="hidden" name="inStock" value="<c:out value= '${productDTO.inStock}' />"/></td>
        </tr>
        <tr>
            <td>Quantity:</td>
            <td><input type="text" name="quantity" value="${orderDetail.quantity}"/> </td>
            <td align="left"><form:errors path="quantity" cssClass="error"/></td>

        </tr>
        <tr>
            <td>OrderID:</td>
            <td><input type="text" name="orderID" value="${orderID}"/> </td>

        </tr>

                <td>
                    <a href="/buy?orderID=${orderID}&productID=${productDTO.productID}"><button>BUY</button></a>

                </td>


    </table>
    </form>
</div>
</body>
</html>