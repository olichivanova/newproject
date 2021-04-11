<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<div align="center">
    <h2>Edit Product</h2>
    <form:form action="/save-pr" method="post" modelAttribute="product" >
        <table border="2" cellpadding="7">
            <tr>
                <td>ID:</td>
                <td><input type="hidden" name="productID" value="<c:out value= '${product.productID}' />"/> </td>

            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="productName" value="<c:out value= '${product.productName}' />"/> </td>

            </tr>
            <td><form:label path="category.categoryID">Category:</form:label></td>
            <td>
                <form:select path="category.categoryID" >
                    <form:option value="2">Select a category</form:option>
                    <c:forEach items="${categoryDTOList}" var="category">
                        <form:option value="${category.categoryID}">${category.categoryName}</form:option>
                    </c:forEach>
                </form:select>
            </td>

            <tr>
                <td>Price:</td>
                <td><input type="text" name="price" value="<c:out value= '${product.price}' />"/> </td>

            </tr> <tr>
            <td>Unit:</td>
            <td><input type="text" name="unit" value="<c:out value= '${product.unit}' />"/> </td>

        </tr> <tr>
            <td>InStock:</td>
            <td><input type="text" name="inStock" value="<c:out value= '${product.inStock}' />"/> </td>

        </tr>
            <div align="center"/>
            <td colspan="2"><input type="submit" value="Save"></td>
            </tr>

        </table>

    </form:form>
</div>
</body>
</html>