<%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 01.11.2017
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${requestScope.locale}"/>
<fmt:setBundle basename="resources/geolocation" var="location"/>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="webapp/css/w3.css">
    <link rel="stylesheet" type="text/css" href="webapp/css/mystyle.css">
    <link rel="stylesheet" type="text/css" href="webapp/css/listProducts.css">
    <title>Cart</title>
    <script src="//api-maps.yandex.ru/2.1/?<fmt:message key="maplang" bundle="${location}"/>" type="text/javascript"></script>
</head>
<body>
<script>
    ymaps.ready(function () {
        var myMap = new ymaps.Map('map', {
                center: [59.931666, 30.325708],
                zoom:11
            }, {
                searchControlProvider: 'yandex#search'
            }),

            myMark1 = new ymaps.Placemark([59.927401, 30.359373], {
                hintContent: '<fmt:message key="address1" bundle="${location}"/>',
                balloonContent: '<div><fmt:message key="address1" bundle="${location}"/></div>\n' +
                '<form name="orderForm" action="/DoOrder" method="post">\n' +
                '    <div><input name="address" id="address1" type="hidden" value="<fmt:message key="address1" bundle="${location}"/>"/> </div>\n' +
                '    <div style="padding:0px; margin-top:5px;"> <input class="w3-button w3-blue" id="submit_button" type="submit" value="<fmt:message key="pickhere" bundle="${location}"/>"> </div>\n' +
                '</form>',
                iconContent: '1'
            }),
            myMark2 = new ymaps.Placemark([59.966114, 30.311885], {
                hintContent: '<fmt:message key="address2" bundle="${location}"/>',
                balloonContent: '<div><fmt:message key="address2" bundle="${location}"/></div>\n' +
                '<form name="orderForm" action="/DoOrder" method="post">\n' +
                '    <div><input name="address" id="address2" type="hidden" value="<fmt:message key="address2" bundle="${location}"/>"/> </div>\n' +
                '    <div style="padding:0px; margin-top:5px;"> <input class="w3-button w3-blue" id="submit_button" type="submit" value="<fmt:message key="pickhere" bundle="${location}"/>"> </div>\n' +
                '</form>',
                iconContent: '2'
            });

            myMap.geoObjects
            .add(myMark1)
            .add(myMark2);
    });
</script>
<c:import url="header.jsp">
    <c:param name="hrefFRA" value="/order?lang=fra"/>
    <c:param name="hrefEN" value="/order?lang=en"/>
    <c:param name="hrefRUS" value="/order?lang=rus"/>
</c:import>
<div style=" position:absolute;left:30%; top:100px;">
    <div style="width: 700px; height: 500px" id="map"></div>
    <div>
        <form style="margin-top: 60px;" name="orderFormDel" action="/DoOrder" method="post">
            <label style="font-size: 15px"><fmt:message key="address" bundle="${location}"/></label>
            <input class="w3-input w3-border" type="text" name="address" id="deliveryAddress"/>
            <input name="button" class="w3-button w3-blue" style="margin-top:10px" id="submit_button2" type="submit" value="<fmt:message key="orderdelivery" bundle="${location}"/>">
        </form>
    </div>
</div>
</body>
</html>
