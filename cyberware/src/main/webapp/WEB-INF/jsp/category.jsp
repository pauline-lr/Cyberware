<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<html>
<head>
    <link type="text/css" href="<spring:url value="/css/category.css"/>" rel="Stylesheet">
    <title><spring:message code="categoriesTitle"/></title>
</head>
<body>
<h1><spring:message code="categoriesTitle"/></h1>
<p><spring:message code="categoryLabel"/></p>
<div class="container">
    <div class="row">
        <!--category = categoryTranslation-->
        <c:forEach var="category" items="${categories}">
            <!--On récupère l'id de la category via la FK avec getCategory()-->
            <a class="aCategory col-lg-4" href="<spring:url value="/catalog/${category.getCategory().getIdentifier()}"/>">
                <div class="cardCategory card p-3 shadow">
                    <div class="d-flex flex-row mb-3">
                        <img class="imgCategory" alt="${category.getName()}" src="<spring:url value="/image/category/${category.getCategory().getImageName()}"/>"/>
                        <div class="textCategory d-flex flex-column ml-2">
                            <h5>${category.getName()}</h5>
                            <span>${category.getCategory().getDescription()}</span>
                        </div>
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>
</div>
</body>
</html>