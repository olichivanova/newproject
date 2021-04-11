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
    <h2>New Product</h2>
    <form:form action="/save-product" method="post" modelAttribute="product" >
        <table border="0" cellpadding="5">
            <tr>
                <td>ID:</td>
                <td><input type="hidden" name="productID" value="${productID}" /></td>

            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="productName" value="${productName}"/></td>

            </tr>

            <tr>
                <td>Price:</td>
                <td><input type="text" name="price" value="${price}"/></td>

            </tr>
            <tr>
                <td>Unit:</td>
                <td><input type="text" name="unit" value="${unit}" /></td>

            </tr>
            <tr>
                <td>InStock:</td>
                <td><input type="text" name="inStock" value="${inStock}"/></td>

            </tr>

            <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>

        <table border="0" cellpadding="5">
            <tr>Save in category:</td>
                <td><input type="hidden" name="categoryID" value="<c:out value= '${category.categoryID}' />"/> </td>

            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="categoryName" value="<c:out value= '${category.categoryName}' />"/> </td>

            </tr>
            <tr>
                <td>Description:</td>
                <td><input type="text" name="description" value="<c:out value= '${category.description}' />"/> </td>

            </tr>
        </table>
    </form:form>

        </td>
    </tr>
</div>
</body>
</html>