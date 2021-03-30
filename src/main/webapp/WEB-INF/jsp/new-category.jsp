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
    <h2>New Category</h2>
    <form:form action="/save" method="post" modelAttribute="category">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID:</td>
                <td><input type="text" name="categoryID" value="${categoryID}"/></td>

            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="categoryName" value="${categoryName}"/></td>

            </tr>
            <tr>
                <td>Description:</td>
                <td><input type="text" name="description" value="${description}"/></td>

            </tr>

                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>