<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Personal information</title>
    <style>
        .error {
            color: red; font-weight: bold;
        }
    </style>
</head>

<h2>Hello, please write your personal information:</h2>
<br><br>
<form action="/save-client" method=post modelAttribute="client">

        <input type="hidden" name="clientID" value="${client.clientID}" >
    <tr>
        <td><form:label path="client.lastName">Please Enter Your Last Name:</td></form:label>
        <td> <form:input path="client.lastName"/></td>
    <td ><form:errors path="client.lastName" cssClass="error"/></td>
    </tr>
    <p><strong>Please Enter Your First Name: </strong>
        <input type="text" name="firstName" value="${client.firstName}" >
    <td ><form:errors path="firstName" cssClass="error"/></td>
    <p><strong>Please Enter Your Age: </strong>
        <td><input type="text"  name="age" value="${client.age}" > <td>
    <td align="left"><form:errors path="age" cssClass="error"/></td>
    <p><strong>Please Enter Your Address: </strong>
    <p><strong>City: </strong>
        <input type="text" name="address.city" value="${client.address.city}">

    <p><strong>Street: </strong>
        <input type="text" name="address.street" value="${client.address.street}">

    <p><strong>Number of building: </strong>
        <input type="text" name="address.numberOfBuilding" value="${client.address.numberOfBuilding}">

    <input type="submit" value="Confirm">

</form>
</html>