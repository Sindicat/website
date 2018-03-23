<%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 01.11.2017
  Time: 0:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MyProfile</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="webapp/css/w3.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <fmt:setLocale value="${requestScope.locale}"/>
        <fmt:setBundle basename="resources/interface" var="inter"/>
        <jsp:useBean id="defT" type="processing.DefT" scope="session"/>
        <title>Title</title>
</head>
<body>
<script>
    function setDefaultTab(param) {
        var strreq = "/setab?tab=" + param;
        var req = new XMLHttpRequest();
        req.onreadystatechange = function () {
            if (req.readyState == 4)
            {
            }
        }
        req.open("GET", strreq, true);
        req.send(null);
        if(param=='1')
        {
            document.getElementById('defBtn').innerHTML='<fmt:message key="briefly_tab" bundle="${inter}"/>';
        }
        if(param=='2')
        {
            document.getElementById('defBtn').innerHTML='<fmt:message key="fully_tab" bundle="${inter}"/>';
        }
        if(param=='3')
        {
            document.getElementById('defBtn').innerHTML='<fmt:message key="feedbacks_tab" bundle="${inter}"/>';
        }
    }
</script>
<c:import url="header.jsp">
    <c:param name="hrefFRA" value="/profile?lang=fra"/>
    <c:param name="hrefEN" value="/profile?lang=en"/>
    <c:param name="hrefRUS" value="/profile?lang=rus"/>
</c:import>
<div style="position: fixed;top: 50%; left:50%;">
    <div style="position: absolute; top: -300px; left: -300px; width: 600px; height:600px; padding: 10px;" class="w3-card-4">
        <div style="float: left">
            <div id="username" style="font-size: 20px; margin-left: 0px"> <fmt:message key="profilename" bundle="${inter}"/> ${pageContext.request.userPrincipal.name}</div>
            <div style="margin-top: 10px">
                <textarea id="textArea" cols="28" rows="4" maxlength="200"></textarea>
            </div>
            <div style="margin-top: 5px; margin-left: 100px">
                <input type="button" class="w3-blue w3-button w3-circle" onclick="sendAjaxRequest('&num=last')" value="<fmt:message key="send" bundle="${inter}"/>">
            </div>
            <div style="font-size: 17px; margin-top: 30px;" ><fmt:message key="choosetab" bundle="${inter}"/> </div>
            <div style="padding-top:10px;" class="w3-dropdown-hover">
                <button id="defBtn" class="w3-button w3-black" style="width: 280px"></button>
                <div class="w3-dropdown-content w3-bar-block w3-border" style="width: 280px;">
                    <input type="button" class="w3-bar-item w3-button" onclick="setDefaultTab('1')" value="<fmt:message key="briefly_tab" bundle="${inter}"/>"/>
                    <input type="button" class="w3-bar-item w3-button" onclick="setDefaultTab('2')" value="<fmt:message key="fully_tab" bundle="${inter}"/>"/>
                    <input type="button" class="w3-bar-item w3-button" onclick="setDefaultTab('3')" value="<fmt:message key="feedbacks_tab" bundle="${inter}"/>"/>
                </div>
            </div>
        </div>
        <div style="font-size: 16px; margin-left: -100px" id="clock"></div>
        <div id="listComments" style="padding-left: 10px; margin-top: 10px; height: 500px; overflow-y: scroll">
        </div>
    </div>
</div>
<script>setDefaultTab(${defT.mark})</script>
<script src="webapp/AddComment.js"></script>
<script src="webapp/GetTime.js"></script>
</body>
</html>
