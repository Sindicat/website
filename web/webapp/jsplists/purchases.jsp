<%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 10.11.2017
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="webapp/css/w3.css">
    <link rel="stylesheet" type="text/css" href="webapp/css/mystyle.css">
    <link rel="stylesheet" type="text/css" href="webapp/css/listProducts.css">
    <title>Purchases</title>
    <jsp:useBean id="historyList" type="processing.ListOrders" scope="request"/>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <fmt:setLocale value="${requestScope.locale}"/>
    <fmt:setBundle basename="resources/interface" var="inter"/>
</head>
<body>
<c:import url="header.jsp">
    <c:param name="hrefFRA" value="/purchases?lang=fra"/>
    <c:param name="hrefEN" value="/purchases?lang=en"/>
    <c:param name="hrefRUS" value="/purchases?lang=rus"/>
</c:import>
<div style="position: absolute; margin-top: 50px; left: 20%">
    <div id="fc" style="font-size: 30px">
    </div>
    <c:set var="isempty" scope="request" value="1"/>
    <c:forEach items="${historyList.list}" var="order">
                    <c:import url="cartHistory.jsp">
                        <c:param name="id" value="${order.id}"/>
                        <c:param name="quantity" value="${order.num}"/>
                        <c:param name="date" value="${order.date}"/>
                    </c:import>
                    <c:set var="isempty" scope="request" value="0"/>
    </c:forEach>
    <c:if test="${isempty.toString() eq '1'.toString()}">
        <div style="font-size: 30px;"> <fmt:message key="emptyhistory" bundle="${inter}"/> </div>
    </c:if>
</div>
</body>
</html>
