<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>PRODUCT</title>
</head>
<body>
<div align="center">
    <h2>INFORMATION OF PRODUCT</h2>
    <div align="left">
        <h3><a href="/new-client">MAKE ORDER</a></h3>
    </div>
    <form action="/new-client" method="get">
        <table border="2" cellpadding="7">

            <tr>
                <td>Category</td>
                <td>${productDTO.getCategory().getCategoryName()}</td>
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
                <td>Quantity:</td>
                <td><input type="text" name="quantity" value="${orderDetail.quantity}"/> </td>

            </tr>


            <td>
                <a href="/new-client"><button>BUY</button></a>

            </td>


        </table>
    </form>
</div>
</body>
</html>