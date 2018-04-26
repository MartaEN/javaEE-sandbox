<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>CHECKOUT</title>
    <jsp:include page="fragments/head.jsp"/>
</head>
<body>
    <div class="container">
        <div class="content">
            <jsp:include page="fragments/header.jsp"/>
            <div class="horiz-section padding-site">
                <h3>Checkout</h3>
                <br>
                <p>username: <%= request.getAttribute("username") %></p>
                <br>
                <p>...page under development...</p>
                <br>
                <a href="sign-out">Sign out</a>
            </div>
        </div>
        <jsp:include page="fragments/footer.jsp"/>
    </div>
</body>
</html>
