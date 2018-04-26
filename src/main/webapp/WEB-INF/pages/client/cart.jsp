<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>CART</title>
    <jsp:include page="fragments/head.jsp"/>
</head>
<body>
<div class="container">
    <div class="content">
        <jsp:include page="fragments/header.jsp"/>
        <div class="horiz-section padding-site">
            <h3>Your cart</h3>
            <p>...page under development...</p>
            <table style="border: 1px solid black; margin-bottom:40px;" >
                <tr>
                    <td>id</td>
                    <td>Product name</td>
                    <td>Unit price</td>
                    <td>Quantity</td>
                    <td>Total cost</td>
                </tr>
                <c:forEach var="line" items="#{cart.items}">
                    <tr>
                        <td>${line.key.id}</td>
                        <td>${line.key.name}</td>
                        <td>${line.key.price}</td>
                        <td>${line.value}</td>
                        <td>${line.value} * ${line.key.price}</td>
                    </tr>
                </c:forEach>
            </table>
            <a href="checkout" class="red-button">checkout <i class="fas fa-angle-right"></i></a>
        </div>
    </div>
    <jsp:include page="fragments/footer.jsp"/>
</div>
</body>
</html>
