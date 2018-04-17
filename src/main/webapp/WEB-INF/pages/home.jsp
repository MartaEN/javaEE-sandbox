<%@ page import="com.marta.sandbox.entity.ProductList" %>
<%@ page import="com.marta.sandbox.entity.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ProductList list = (ProductList) request.getAttribute("products"); %>
<html lang="en">
<head>
    <title>INTERIOR</title>
    <jsp:include page="fragments/head.jsp"/>
</head>
<body>
    <div class="container">
        <div class="content">
            <div class="slider">
                <img class="slider-background" src="img/slider-1.jpg" alt="promo">
                <div class="slider-content padding-asymmetric">
                    <jsp:include page="fragments/header.jsp"/>
                    <div class="slider-text">
                        <h4 class="trending">TRENDING</h4>
                        <h2>Fishnet Chair</h2>
                        <p>Seat and back with upholstery made of cold cure foam. Steel frame, available in matt powder-coated black or highly polished chrome.</p>
                        <a class="action-label action-button" href="product?id=99">Order Us <i class="fas fa-angle-right"></i></a>
                    </div>
                </div>
            </div>
            <div class="horiz-section padding-site">
                <div class="header">
                    <h3>Trending products</h3>
                    <a href="#" class="action-label">explore all <i class="fas fa-angle-right"></i></a>
                </div>
                <div class="section-trending gallery size370 margin-top">
                    <%--Получилось только скриптлетом ((( --%>
                    <%
                        for (Product p: list.getList()) {
                            out.print("<a href=\"product?id=" + p.getId() + "\">" +
                                    "<img src=\"" + p.getImage() + "\" alt=\"" + p.getName() + "\"></a>");
                        }
                    %>
                    <%--Таглибом не получилось!!! Совсем!!!--%>
                    <c:forEach var="product" items="${products.list}">
                        <a href="product?id=${product.id}"><img src="${product.image}" alt="${product.name}" ></a>
                    </c:forEach>
                </div>
            </div>
        </div>

        <jsp:include page="fragments/footer.jsp"/>

    </div>
</body>
</html>
