<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 03.10.2018
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<form action="/registration" method="post" title="Создать пользователя">
    <br>Login:<br>
    <input required type="login" name="login" title="Логин"/><br>
    <br>Password:<br>
    <input required type="password" name="password" title="Пароль"/><br>
    <br>Name:<br>
    <input required type="name" name="name" title="Имя"/><br>
    <br>Surname:<br>
    <input required type="surname" name="surname" title="Фамилия"/><br>
    <br><input type="submit" title="ok"><br>

</form>

<c:if test="${'ChangeLogin'.equals(param.error)}">
    <strong>Login already exist!</strong>
</c:if>

<c:if test="${'LoginToEnter'.equals(param.loginToEnter)}">
    <strong>Registration successful. Login to enter.</strong>
</c:if>

<%@include file="footer.jsp" %>