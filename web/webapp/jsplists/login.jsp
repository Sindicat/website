<%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 31.10.2017
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="webapp/css/w3.css">
    <fmt:setLocale value="${requestScope.locale}"/>
    <fmt:setBundle basename="resources/interface" var="inter"/>
</head>
<body>
<c:import url="header.jsp">
    <c:param name="hrefFRA" value="/login?lang=fra"/>
    <c:param name="hrefEN" value="/profile?lang=en"/>
    <c:param name="hrefRUS" value="/profile?lang=rus"/>
</c:import>
<div style="position: fixed; top: 50%; left:50%;">
    <div style="position: absolute; top: -200px; left: -250px; width: 500px; height:300px;" class="w3-card-4">
        <div class="w3-black" style="margin-top: -8px;">
            <h2 style="text-align: center; "> <fmt:message key="welcome" bundle="${inter}"/> </h2>
        </div>
        <form action="j_security_check" method="post" name="loginForm" class="w3-container">
            <label> <b><fmt:message key="username" bundle="${inter}"/></b> </label>
            <input class="w3-input w3-border w3-light-gray" name="j_username" type="text"/>
            <label > <b><fmt:message key="password" bundle="${inter}"/></b> </label>
            <input class="w3-input w3-border w3-light-gray" name="j_password" type="password"/>
            <input style="margin-top: 10px;" class="w3-btn w3-blue" type="submit" value="<fmt:message key="login" bundle="${inter}"/>"/>
        </form>


    </div>
</div>
</body>
</html>
