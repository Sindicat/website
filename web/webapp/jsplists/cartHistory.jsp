<%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 10.11.2017
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <fmt:setLocale value="${requestScope.locale}"/>
    <c:if test="${param.id.toString() eq '0'.toString() }">
        <fmt:setBundle basename="resources/beats" var="language"/>
    </c:if>
    <c:if test="${param.id.toString() eq '1'.toString() }">
        <fmt:setBundle basename="resources/jbl" var="language"/>
    </c:if>
    <c:if test="${param.id.toString() eq '2'.toString() }">
        <fmt:setBundle basename="resources/parrot" var="language"/>
    </c:if>
    <c:if test="${param.id.toString() eq '3'.toString() }">
        <fmt:setBundle basename="resources/sennheiser" var="language"/>
    </c:if>
    <c:if test="${param.id.toString() eq '4'.toString() }">
        <fmt:setBundle basename="resources/sony" var="language"/>
    </c:if>
    <fmt:setBundle basename="resources/interface" var="interf"/>
</head>
<div class="w3-panel w3-card cardInCart ">
    <div style="float: left" >
        <img src="<fmt:message key="imagespath" bundle="${language}"/>1.jpg" width="200" height="200">
    </div>
    <div  style="float: left; padding-left: 20px; padding-bottom: 20px; width: 500px; height: 200px" >
        <div><p> <fmt:message key="product_name" bundle="${language}"/> </p></div>
        <div > <fmt:message key="briefly" bundle="${language}"/> </div>
    </div>
    <div  style="float: left;padding-top: 0px; padding-left: 20px;padding-right: 20px;padding-bottom: 20px; width: 200px; height: 200px;" >
        <div style="font-size: 18px;"> <fmt:message key="num" bundle="${interf}"/>: ${param.quantity} </div>
        <div style="margin-top:10px;">
            <div style="font-size: 18px;"> <fmt:message key="date" bundle="${interf}"/>: ${param.date} </div>
        </div>

    </div>
    <div style="clear: left"></div>
</div>
</html>
