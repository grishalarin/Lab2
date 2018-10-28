<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 03.10.2018
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<form action="/login" method="post" title="Создать пользователя">
    <br>Login<br>
    <input type="login" name="login" title="Логин"/><br>
    <br>Password<br>
    <input type="password" name="password" title="Пароль"/><br>
    <br><input type="submit" title="ok"><br>
</form>
<c:if test="${'wrongLogin'.equals(param.errorCode)}">
    <strong>Wrong Login!</strong>
</c:if>

<c:if test="${'accessDenied'.equals(param.errorAccessDenied)}">
    <strong>Access Denied!</strong>
</c:if>

<%@include file="footer.jsp" %>
