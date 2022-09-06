<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
<head>
    <link type="text/css" href="<spring:url value="/css/signin.css"/>" rel="Stylesheet">
    <title><spring:message code="signinTitle"/></title>
</head>
<body>
<h1><spring:message code="signinTitle"/></h1>
<p><spring:message code="signinLabel"/></p>
<div class="list-group">
    <form:form id="form" method="POST" action="/cyberware/signin/send" modelAttribute="customer">
    <div class="bigDivInput">
        <div class="littleDivInput">
            <form:label path="firstName">
                <spring:message code="customerFormFirstNameLabel"/>
            </form:label>
            <form:errors path="firstName"> : <form:errors path="firstName" cssStyle="color: red"/></form:errors>
            <br>
            <form:input class="realInput" path="firstName"/>
        </div>
        <div class="littleDivInput">
            <form:label path="lastName">
                <spring:message code="customerFormLastNameLabel"/>
            </form:label>
            <form:errors path="lastName"> : <form:errors path="lastName" cssStyle="color: red"/></form:errors>
            <br>
            <form:input class="realInput" path="lastName"/>
        </div>
    </div>
    <div class="bigDivInput">
        <div class="littleDivInput">
            <form:label path="username">
                <spring:message code="customerFormUsernameLabel"/>
            </form:label>
            <form:errors path="username"> : <form:errors path="username" cssStyle="color: red"/></form:errors>
            <br>
            <form:input class="realInput" path="username" type="email"/>
        </div>
        <div class="littleDivInput">
            <form:label path="phoneNumber">
                <spring:message code="customerFormPhoneNumberLabel"/>
            </form:label>
            <form:errors path="phoneNumber">: <form:errors path="phoneNumber" cssStyle="color: red"/></form:errors>
            <br>
            <form:input class="realInput" path="phoneNumber"/>
        </div>
    </div>
    <div class="bigDivInput">
        <div class="largeDivInput">
            <form:label path="address">
                <spring:message code="customerFormAddressLabel"/>
            </form:label>
            <form:errors path="address"> : <form:errors path="address" cssStyle="color: red"/></form:errors>
            <br>
            <form:input class="realLargeInput" path="address"/>
        </div>
    </div>
    <div class="bigDivInput">
        <div class="largeDivInput">
            <form:label path="password">
                <spring:message code="customerFormPasswordLabel"/>
            </form:label>
            <form:errors path="password"> : <form:errors path="password" cssStyle="color: red"/></form:errors>
            <br>
            <form:password class="realLargeInput" path="password"/>
        </div>
    </div>
</div>
<div class="divButton">
    <form:button class="btn btn-lg btn-primary btn-block">
        <spring:message code="signinTitle"/>
    </form:button>
</div>
</form:form>
</body>
</html>