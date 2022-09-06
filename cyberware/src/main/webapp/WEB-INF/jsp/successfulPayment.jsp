<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
<head>
    <link type="text/css" href="<spring:url value="/css/payment.css"/>" rel="Stylesheet">
    <title><spring:message code="successfulPaymentTitle"/></title>
</head>
<body>
<h1><spring:message code="successfulPaymentTitle"/></h1>
<p><spring:message code="successfulPaymentLabel"/> ✅</p>
</body>
</html>
