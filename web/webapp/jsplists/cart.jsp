<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 28.10.2017
  Time: 18:43
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
    <title>Cart</title>
    <jsp:useBean id="interfaceBean" type="processing.Interface" scope="request"/>
    <jsp:useBean id="orders" type="processing.ListOrders" scope="request"/>
    <jsp:useBean id="db" type="processing.DataBase" scope="request"/>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <fmt:setLocale value="${requestScope.locale}"/>
    <fmt:setBundle basename="resources/interface" var="inter"/>
</head>
<body>
<script>
    function fullCost() {
        var sum=0;
        for( var i=0; i<5;++i)
        {
            var str="";
            var div = document.getElementById(i.toString());
            if(div!=null) {
                str = div.innerHTML;
                str = str.replace("$", "");
                str = str.replace("€", "");
                str = str.replace("₽", "");
                str = str.replace(" ", "");
                sum += parseInt(str);
            }
        }
        var cost = document.getElementById("fullcost");
        cost.innerHTML += sum;
    }
</script>

<c:import url="header.jsp">
    <c:param name="hrefFRA" value="/cart?lang=fra"/>
    <c:param name="hrefEN" value="/cart?lang=en"/>
    <c:param name="hrefRUS" value="/cart?lang=rus"/>
</c:import>
<div style="position: absolute; margin-top: 50px; left: 20%">
<div id="fc" style="font-size: 30px">
</div>
    <c:set var="isempty" scope="request" value="1"/>
<c:forEach items="${db.productsList}" var="product">
    <c:forEach items="${orders.list}" var="order">
        <c:if test="${product.id.toString() eq order.id.toString()}">
            <c:if test="${order.num.toString() ne '0'.toString()}">
            <c:import url="cartCard.jsp">
                <c:param name="id" value="${product.id}"/>
                <c:param name="quantity" value="${order.num}"/>
            </c:import>
                <c:set var="isempty" scope="request" value="0"/>
            </c:if>
        </c:if>
    </c:forEach>
</c:forEach>
    <c:if test="${isempty.toString() eq '1'.toString()}">
        <div style="font-size: 30px;"> <fmt:message key="emptycart" bundle="${inter}"/> </div>
    </c:if>
    <c:if test="${isempty.toString() eq '0'.toString()}">
   <div id="fullcost" style="font-size: 30px;"><fmt:message key="fullcost" bundle="${inter}"/> <fmt:message key="symbol" bundle="${inter}"/> </div>
        <script> fullCost()</script>
        <a class="w3-button w3-round w3-blue" href="/order?lang=<%=request.getParameter("lang")%>" style="width: 160px; margin-top: 10px;"><fmt:message key="buy_button" bundle="${inter}"/></a>
    </c:if>
</div>
<script src="webapp/AddOrder.js"></script>
</body>
</html>
