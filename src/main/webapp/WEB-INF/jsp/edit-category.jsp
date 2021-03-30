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
    <h2>Edit Category</h2>
    <form:form action="/save" method="post" modelAttribute="category" >
        <table border="2" cellpadding="7">
            <tr>
                <td>ID:</td>
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
<div align="center"/>
            <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>