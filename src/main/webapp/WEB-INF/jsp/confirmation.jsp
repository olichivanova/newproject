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
    <h2>INFORMATION OF ORDER</h2>
<table>
   <td> <th> <c:out value="${orderDTO.orderID}"/></th></td>
   <td><th> <c:out value="${orderDTO.orderDate}"/></th></td>
    <th> <c:out value="${orderDTO.client.clientID}"/></th>
    <th> <c:out value="${orderDTO.client.firstName}"/></th>
    <th> <c:out value="${orderDTO.client.lastName}"/></th>
    <th> <c:out value="${orderDTO.client.age}"/></th>
    <th> <c:out value="${orderDTO.client.address}"/></th>


        <c:forEach items="${orderDTO.orderDetailDTOS}" var="orderDetail">
            <tr>

            <tr>  <td>${orderDetail.orderDetailID}</td></tr>
            <tr><td>${orderDetail.quantity}</td></tr>
                <td>${orderDetail.price}</td>
                <td>${orderDetail.total}</td>
                <td>${orderDetail.product.productName}</td>
                <td>${orderDetail.quantity}</td>


            </tr>
        </c:forEach>
</table>
    <button><a href="/remove?orderID=${orderDTO.orderID}">NO</a></button>
    <button><a href="/products-home">YES</a></button>

</div>
</body>
</html>