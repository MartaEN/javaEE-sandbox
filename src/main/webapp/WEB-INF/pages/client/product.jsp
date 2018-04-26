<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<html lang="en">

<head>
    <title>${product.name}</title>
    <jsp:include page="fragments/head.jsp"/>
</head>

<body>
<div class="container">
    <div class="content">
        <jsp:include page="fragments/header.jsp"/>
        <ul class="menu3">
            <li><a href="#" class="active-link ">all</a></li>
            <li><a href="#">home</a></li>
            <li><a href="#">office</a></li>
            <li><a href="#">furniture</a></li>
            <li><a href="#">modern</a></li>
            <li><a href="#">classic</a></li>
        </ul>
        <div class="product-expo side-by-side padding-site">
            <div class="product-expo-photo">
                <img class="option-selected" src="${product.image}" alt="${product.name}">
                <ul class="options-slider">
                    <li><a href="#"><img src="${product.image}" alt="${product.image}"></a></li>
                    <li><a href="#"><img src="${product.image}" alt="${product.image}"></a></li>
                    <li><a href="#"><img class="current-selection" src="${product.image}" alt="${product.image}"></a></li>
                </ul>
            </div>
            <div class="product-expo-info">
                <h3>${product.name}</h3>
                <h4 class="hot">hot deal</h4>
                <div class="price">&#36; <span class="price-focus">${product.price}</span>/sq</div>
                <a href="cart?add-product=${product.id}" class="red-button">order us <i class="fas fa-angle-right"></i></a>
                ${product.description}
            </div>
        </div>
        <div class="horiz-section padding-site">
            <div class="header">
                <h3>Related products</h3>
                <a href="#" class="action-label">explore all <i class="fas fa-angle-right"></i></a>
            </div>
            <div class="section-trending gallery size370 margin-top">
                <%--Пока статикой--%>
                <a href="product?id=11"><img src="img/product-11.jpg" alt="product11"></a>
                <a href="product?id=21"><img src="img/product-21.jpg" alt="product21"></a>
                <a href="product?id=31"><img src="img/product-31.jpg" alt="product31"></a>
            </div>
        </div>
    </div>
    <jsp:include page="fragments/footer.jsp"/>
</div>
</body>

</html>
