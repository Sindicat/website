<%@ page import="processing.ListOrders" %><%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 22.10.2017
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${requestScope.locale}"/>
<fmt:setBundle basename="resources/interface" var="inter"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<div class = "w3-bar w3-black" style="height: 38px;">
    <a class="w3-bar-item w3-button " href="/products?lang=<%=request.getParameter("lang")%>&from=0&to=100000&filter=0" style="padding-top: 2px;"><div class="fa fa-home w3-xxlarge"> </div> </a>
    <% if (!request.isUserInRole("tomcat"))
    {%>
        <a class="w3-bar-item w3-button" href="/profile?lang=<%=request.getParameter("lang")%>"><fmt:message key="login" bundle="${inter}"/></a>
    <%}
    else {%>
        <a class="w3-bar-item w3-button" href="/logout?lang=<%=request.getParameter("lang")%>"><fmt:message key="logout" bundle="${inter}"/></a>
        <a class="w3-bar-item w3-button" href="/profile?lang=<%=request.getParameter("lang")%>"><fmt:message key="myprofile" bundle="${inter}"/>(<%=request.getUserPrincipal().getName().toString()%>)</a>
    <%if (!(((ListOrders)request.getSession().getAttribute("orders")).isEmpty())) {%>
    <a class="w3-bar-item w3-button" href="/order?lang=<%=request.getParameter("lang")%>"><fmt:message key="checkout" bundle="${inter}"/></a>
    <%}
    }%>
    <a class="w3-bar-item w3-button" href="/cart?lang=<%=request.getParameter("lang")%>"><fmt:message key="cart" bundle="${inter}"/> </a>
    <a class="w3-bar-item w3-button" href="/purchases?lang=<%=request.getParameter("lang")%>"><fmt:message key="history" bundle="${inter}"/></a>
        <a style="float:right" class="w3-bar-item w3-button" href="${param.hrefFRA}">FRA</a>
        <a style="float:right" class="w3-bar-item w3-button" href="${param.hrefEN}">ENG</a>
        <a style="float:right" class="w3-bar-item w3-button" href="${param.hrefRUS}">RUS</a>
</div>
