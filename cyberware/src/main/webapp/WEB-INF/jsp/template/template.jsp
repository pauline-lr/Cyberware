<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="../include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
<head>
    <link type="text/css" href="<spring:url value='/css/template/template.css' />" rel="Stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous">
    </script>
    <link rel="shortcut icon" type="image/png" href="<spring:url value="/image/home/cyberware.png"/>"/>
    <spring:url var="localeFr" value="">
        <spring:param name="locale" value="fr"/>
    </spring:url>
    <spring:url var="localeEn" value="">
        <spring:param name="locale" value="en"/>
    </spring:url>
    <title>Cyberware</title>
    <meta name="theme-color" content="#FFFF00">
</head>
<body style="background-color: black; color: #FFFF00">
<div id="page-container">
    <div id="content-wrap">
        <nav class="divNavBar navbar navbar-expand-lg navbar-light bg-light navbar-custom">
            <div class="divContainer container-fluid" style="background-color: #FFFF00; color: black;">
                <!-- Cyberware -->
                <a class="navbar-brand" href="<spring:url value="/"/>">
                    <img class="imgCyberware" alt="Cyber" src="<spring:url value="/image/home/cyberware.png"/>"/>
                </a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <!-- Categories -->
                        <li class="nav-item">
                            <a class="nav-link" href="<spring:url value="/category"/>" style="color: black">
                                <spring:message code="categoriesTitle"/> 🦾
                            </a>
                        </li>
                        <!-- Items -->
                        <li class="nav-item">
                            <a class="nav-link" href="<spring:url value="/catalog"/>" style="color: black">
                                <spring:message code="itemsTitle"/> 🦿
                            </a>
                        </li>
                    </ul>
                    <ul class="nav justify-content-end">
                        <!-- Account -->
                        <li class="nav-item dropdown" style="padding: 8px">
                            <a class="nav-link dropdown-toggle" id="accountDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="color: black; padding: 0">
                                <sec:authorize access="!isAuthenticated()">
                                    <spring:message code="accountTitle"/> 👤
                                </sec:authorize>
                                <sec:authorize access="isAuthenticated()">
                                    <sec:authentication property="principal.firstName"/> 👤
                                </sec:authorize>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="accountDropdown" style="color: black; background-color: #FFFF00">
                                <sec:authorize access="!isAuthenticated()">
                                    <!-- Log In -->
                                    <li>
                                        <a class="dropdown-item" href="<spring:url value="/login"/>">
                                            <spring:message code="loginTitle"/>
                                        </a>
                                    </li>
                                    <!-- Sign In -->
                                    <li>
                                        <a class="dropdown-item" href="<spring:url value="/signin"/>">
                                            <spring:message code="signinTitle"/>
                                        </a>
                                    </li>
                                </sec:authorize>
                                <sec:authorize access="isAuthenticated()">
                                    <!-- Log Out -->
                                    <li>
                                        <a class="dropdown-item" href="<spring:url value="/logout"/>">
                                            <spring:message code="logoutTitle"/>
                                        </a>
                                    </li>
                                </sec:authorize>
                            </ul>
                        </li>
                        <!-- Language -->
                        <li class="nav-item dropdown" style="padding: 8px">
                            <a class="nav-link dropdown-toggle" id="languageDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="color: black; padding: 0">
                                <spring:message code="languageTitle"/> 🇪🇺
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="languageDropdown" style="color: black; background-color: #FFFF00">
                                <!-- English -->
                                <li>
                                    <a class="dropdown-item" href="${localeEn}">
                                        <img class="imgLanguage" alt="English" src="<spring:url value="/image/language/english.png"/>"/>
                                        <spring:message code="englishTitle"/>
                                    </a>
                                </li>
                                <!-- French -->
                                <li>
                                    <a class="dropdown-item" href="${localeFr}">
                                        <img class="imgLanguage" alt="French" src="<spring:url value="/image/language/french.png"/>"/>
                                        <spring:message code="frenchTitle"/>
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <!-- Cart -->
                        <li class="nav-item" style="padding: 8px 16px 8px 8px">
                            <a class="nav-link" href="<spring:url value="/cart"/>" style="color: black; padding: 0">
                                <spring:message code="cartTitle"/> 🛒
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div>
            <tiles:insertAttribute name="main-content"/>
        </div>
    </div>
    <div>
        <footer class="text-center text-lg-start bg-light text-muted">
            <div class="text-center p-4" style="background-color: #FFFF00; color: black;">
                Hénallux - Pauline Loréa & Jonathan Smith
            </div>
        </footer>
    </div>
</div>
</body>
</html>