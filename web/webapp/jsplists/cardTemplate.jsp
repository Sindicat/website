<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="resources/interface" var="inter"/>
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8">  </head>
    <div class="w3-card card">
        <div class="namecard"><%=elem.getName()%> </div>
        <a href="<%=elem.getReference()%>">
        <img src="<%=elem.getPathToImages()%>1.jpg" width="370px" height="370px"> </img>
        </a>
        <div class="overviewCard"><%=elem.getBriefly()%></div>
        <div class="price"><fmt:message key="symbol" bundle="${inter}"/> <%=elem.getPrice()%> </div>
        <div class="buyButtonCard" > <button class="w3-button w3-round w3-blue" onclick="addOrder(<%=elem.getId()%>,'1')">${interfaceBean.addToCart}</button></div>
    </div>