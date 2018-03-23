<%@ page import="processing.DataBase" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="processing.Product" %>
<%@ page import="processing.Interface" %>
<%@ page import="java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ñ" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="cp1251" language="java" %>

<%
    Cookie cookieFROM=null;
    Cookie cookieTO=null;
    Cookie[] cookies = request.getCookies();
    if(cookies!=null) {
        for (Cookie cookie :
                cookies) {
            if ("from".equals(cookie.getName())) {
                cookieFROM = cookie;
            }
            if ("to".equals(cookie.getName())) {
                cookieTO = cookie;
            }
        }
    }
        if(cookieFROM==null && cookieTO==null) {
            cookieFROM = new Cookie("from", request.getParameter("from"));
            response.addCookie(cookieFROM);
            cookieTO = new Cookie("to", request.getParameter("to"));
            response.addCookie(cookieTO);
        }

    if(request.getParameter("filter").equals("0"))
{
%>
<html>
<head>
    <title>Headphones</title>
    <link rel="stylesheet" type="text/css" href="webapp/css/w3.css">
    <link rel="stylesheet" type="text/css" href="webapp/css/mystyle.css">
    <link rel="stylesheet" type="text/css" href="webapp/css/listProducts.css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"\>
    <jsp:useBean id="interfaceBean" type="processing.Interface" scope="request"/>
</head>
<body>
    <%
       String hrefFRA = "/products?lang=fra&from="+cookieFROM.getValue()+"&to="+ cookieTO.getValue()+"&filter=0";
       String hrefEN = "/products?lang=en&from="+cookieFROM.getValue()+"&to="+ cookieTO.getValue()+"&filter=0";
       String hrefRUS = "/products?lang=rus&from="+cookieFROM.getValue()+"&to="+ cookieTO.getValue()+"&filter=0";
%>
    <c:import url="header.jsp">
        <ñ:param name="hrefFRA" value="<%=hrefFRA%>"/>
        <c:param name="hrefEN" value="<%=hrefEN%>"/>
        <c:param name="hrefRUS" value="<%=hrefRUS%>"/>
    </c:import>
    <div class="wrap-card"  >
        <div class="filterField">
            <div style="float: left; margin-top: 5px"><%--=inter.getFilterFrom()--%>${interfaceBean.filterFrom} <input value="<%=cookieFROM.getValue()%>" id="filterFrom" width="200px" type="text" class="textInput"> </div> <div style="float: left; margin-top: 5px; margin-left: 3px;"> <%--=inter.getFilterTo()--%>${interfaceBean.filterTo} <input value="<%=cookieTO.getValue()%>" id="filterTo" type="text" class="textInput"> </div>  <div style="float: left; margin-top: 5px;"> <input type="button" onclick="sendGetRequest('<%=request.getParameter("lang")%>')" class="w3-btn w3-black w3-border" value="<%--=inter.getFilter()--%>${interfaceBean.filter}" style="margin-left: 70px;"> </div>
        </div>
        <div style="clear: left ; margin: 0px; padding: 0px; border: 0px;"></div>
        <div id="cardsContainer">
            <%

                String from = cookieFROM.getValue();
               String to = cookieTO.getValue();
               Integer f = Integer.parseInt(from);
               Integer t = Integer.parseInt(to);
               ArrayList<Product> listproduct = ((DataBase) request.getAttribute("db")).getProductsList();
                for ( int i=0; i<listproduct.size();++i) {
                    Product elem = listproduct.get(i);
                    Integer price = Integer.parseInt(elem.getPrice());
                    if(price >= f && price <= t)
                    {%>
            <%@include file="cardTemplate.jsp"%>
                    <%}
                }%>
        </div>
    </div>
<script src="webapp/SendGetReqFilt.js"></script>
<script src="webapp/AddOrder.js"></script>
</body>
</html>
<%}
else
{
    String from = request.getParameter("from");
String to = request.getParameter("to");
if(!from.equals("")&& !to.equals("")) {
    cookieFROM.setValue(from);
    cookieTO.setValue(to);
    response.addCookie(cookieFROM);
    response.addCookie(cookieTO);
}
else
{
    from = cookieFROM.getValue();
    to = cookieTO.getValue();
}
Integer f = Integer.parseInt(from);
Integer t = Integer.parseInt(to);
ArrayList<Product> listproduct = ((DataBase) request.getAttribute("db")).getProductsList();
for ( int i=0; i<listproduct.size();++i) {
Product elem = listproduct.get(i);
Integer price = Integer.parseInt(elem.getPrice());
if(price >= f && price <= t)
{%>
<%@include file="cardTemplate.jsp"%>
<%}}}%>