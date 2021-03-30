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
    <h2>THE RESULT OF SEARCH</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${result}" var="category">
            <tr>
                <td>${category.categoryName}</td>
                <td>${category.description}</td>

                <td>
                    <button><a href="categories/next?categoryID=${category.categoryID}">OPEN</a></button>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>