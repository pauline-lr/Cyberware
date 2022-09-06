<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
<head>
    <link type="text/css" href="<spring:url value="/css/item.css"/>" rel="Stylesheet">
    <title><spring:message code="${sessionItem.getName()}"/></title>
</head>
<body>
<div class="card px-3 row" style="width: 1000px; height: 500px; background-color: #FFFF00; color: black; margin: 50px auto; border-radius: 7px">
    <div class="col-md-6" style="margin: 40px 20px 40px 24px; padding: 0; width: 420px; height: 420px;">
        <img class="imgItem" alt="${sessionItem.getName()}" src="<spring:url value="/image/item/${sessionItem.getImageName()}"/>"
             style="width: 100%; height: 100%; border: 0; background-color: black; border-radius: 7px"/>
    </div>
    <div class="col-md-6" style="padding: 0; margin: 40px 24px 40px 20px; width: 420px; height: 420px;">
        <form:form id="form" method="POST" action="/cyberware/item/add" modelAttribute="itemForm">
            <div style="position: absolute; top: 40px;">
                <h5>${sessionCategoryTranslation.getName()}</h5>
                <h1 style="margin-bottom: 20px">${sessionItem.getName()}</h1>
                <h6>${sessionItem.getDescription()}</h6>
            </div>
            <div style="position: absolute; bottom: 40px;">
                <h4 style="margin-bottom: 50px">${sessionItem.getPriceDisplayFormat()}</h4>
                <form:label path="quantity">
                    <spring:message code="quantityTitle"/> :
                </form:label>
                <form:input path="quantity" cssStyle="width: 100px; border-radius: 5px; border: solid 1px black"/>
                <form:errors path="quantity">
                    <br>
                    <form:errors path="quantity" cssStyle="color: red"/>
                </form:errors>
                <br>
                <form:button class="btn btn-lg btn-primary btn-block" style="margin-top: 30px; margin-left: auto; margin-right: auto; text-align: center;"><spring:message code="addToCartTitle"/></form:button>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>