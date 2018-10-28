<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 01.10.2018
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
Welcome!
<c:if test="${'LoginToEnter'.equals(param.loginToEnter)}">
    <strong>Registration successful. Login to enter.</strong>
</c:if>
<%@include file="footer.jsp" %>