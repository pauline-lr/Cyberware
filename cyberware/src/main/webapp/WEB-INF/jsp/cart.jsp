<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
<head>
    <link type="text/css" href="<spring:url value="/css/cart.css"/>" rel="Stylesheet">
    <title><spring:message code="cartTitle"/></title>
    <!--  cart = HashMap<Integer, PurchaseLine>-->
    <c:set var="cartContent" value="${sessionCart.getCart().values()}"/>
</head>
<body>
<h1><spring:message code="cartTitle"/></h1>
<p><spring:message code="cartLabel"/></p>
<c:if test="${cartContent.isEmpty()}">
    <p><spring:message code="emptyCartLabel"/>... 🤷‍♂️</p>
</c:if>
<c:if test="${!(cartContent.isEmpty())}">
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th scope="col">
                <spring:message code="imageTitle"/>
            </th>
            <th scope="col">
                <spring:message code="nameTitle"/>
            </th>
            <th scope="col">
                <spring:message code="descriptionTitle"/>
            </th>
            <th class="thPrice" scope="col">
                <spring:message code="priceTitle"/>
            </th>
            <th class="thQuantity" scope="col">
                <spring:message code="quantityTitle"/>
            </th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="purchaseLine" items="${cartContent}">
            <tr>
                <td class="tdImage">
                    <img alt="${purchaseLine.getItem().getName()}"
                         src="<spring:url value="/image/item/${purchaseLine.getItem().getImageName()}"/>"/>
                </td>
                <td class="tdName">
                        ${purchaseLine.getItem().getName()}
                </td>
                <td class="tdDescription">
                        ${purchaseLine.getItem().getDescription()}
                </td>
                <td class="tdPrice">
                        ${purchaseLine.getItemPriceDisplayFormat()}
                </td>
                <td class="tdQuantity">
                    <form:form cssClass="quantityForm" id="plusForm" method="POST" action="/cyberware/cart/add" modelAttribute="item">
                        <form:hidden path="identifier" value="${purchaseLine.getItem().getIdentifier()}"/>
                        <form:button class="quantityButton">+</form:button>
                    </form:form>
                    <div class="quantityDigit">${purchaseLine.getRequestedQuantity()}</div>
                    <form:form cssClass="quantityForm" id="minusForm" method="POST" action="/cyberware/cart/remove" modelAttribute="item">
                        <form:hidden path="identifier" value="${purchaseLine.getItem().getIdentifier()}"/>
                        <form:button class="quantityButton">-</form:button>
                    </form:form>
                </td>
                <td style="background-color: black; border: black; text-align: left; width: 50px">
                    <form:form id="deleteForm" method="POST" action="/cyberware/cart/delete" modelAttribute="item" cssStyle="margin: 0;">
                        <form:hidden path="identifier" value="${purchaseLine.getItem().getIdentifier()}"/>
                        <form:button style="background-color: red; border: 0; border-radius: 5px;">
                            <div>🗑</div>
                        </form:button>
                    </form:form>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <c:if test="${sessionCart.isDiscounted()}">
                <td colspan="3" style="background-color: black; border: black;"></td>
                <td colspan="2">${sessionCart.getInitialTotalPriceDisplayFormat()}</td>
            </c:if>
        </tr>
        <tr>
            <c:if test="${sessionCart.isDiscounted()}">
                <td colspan="3" style="background-color: black; border: black; color: #FFFF00; text-align: right; display: inline-block">
                    <div style="display: inline-block; background-color: green; color: white; border-radius: 2px; padding-left: 5px; padding-right: 5px">
                        ${discount} %
                    </div>
                    <div style="display: inline-block; margin-left: 5px">
                        <spring:message code="discountTitle"/>
                    </div>
                </td>
                <td colspan="2">- ${sessionCart.getAmountSavedDisplayFormat()}</td>
            </c:if>
        </tr>
        <tr style="border-top: solid 2px black">
            <td colspan="3" style="background-color: black; border: black; color: #FFFF00; text-align: right">
                <spring:message code="totalTitle"/></td>
            <td colspan="2">${sessionCart.getFinalTotalPriceDisplayFormat()}</td>
        </tr>
        </tbody>
    </table>
    <form class="divButton" action="<spring:url value="/payment"/>">
        <button class="btn btn-lg btn-primary btn-block"><spring:message code="confirmTitle"/></button>
    </form>
</c:if>
</body>
</html>