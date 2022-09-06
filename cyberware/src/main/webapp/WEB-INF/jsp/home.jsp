<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
<head>
    <link type="text/css" href="<spring:url value="/css/home.css"/>" rel="Stylesheet">
    <title><spring:message code = "cyberwareName"/></title>
</head>
<body>
<div style="position: relative">
    <div style="position: absolute; top: 9.8%; left: 50%; transform: translate(-50%, -50%);">
        <h1><spring:message code="cyberwareName"/></h1>
        <p><spring:message code = "homeLabel"/></p>
    </div>
    <img alt="Mantis" src="<spring:url value="/image/home/home.png"/>" width="100%"/>
</div>
</body>
</html>