<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 03.10.2018
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<table class="minimalistBlack">
    <thead>
    <tr>
        <th>Document Type</th>
        <th>Data</th>
        <th>Save</th>
    </tr>
    </thead>
    <tbody>
    <form method="post" action="/inner/document">
        <tr>
            <td>Passport</td>
            <input type="hidden" value=1 name="docType">
            <%-- <input type="hidden" value="${sessionScope.login}" name="userLogin">--%>
            <td>
                <p><b>Enter passport data.</b></p>
                <p><textarea rows="5" cols="45" name="passport data"></textarea></p>
                <p></p>
            </td>
            <td><input type="submit" name="data" value="Отправить"></td>
            <c:if test="${'SavePass'.equals(param.savePass)}">
                <strong>Changes saved!</strong>
            </c:if>
        </tr>
    </form>
    <form method="post" action="/inner/document">
        <tr>
            <td>Inn</td>
            <input type="hidden" value=2 name="docType">
            <td>
                <p><b>Enter inn data.</b></p>
                <p><textarea rows="5" cols="45" name="inn data"></textarea></p>
                <p></p>
            </td>
            <td><input type="submit" value="Отправить"></td>
            <c:if test="${'SaveInn'.equals(param.saveInn)}">
                <strong>Changes saved!</strong>
            </c:if>
        </tr>
    </form>
    </tbody>
    </tr>
</table>


<%@include file="footer.jsp" %>
