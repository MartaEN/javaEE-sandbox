<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
                Please sign in to proceed
                <form method="post" action="sign-in">
                    <br>Enter(any) username: <br>
                    <input name="username" required/>
                    <input type="submit" value="Sign in"/>
                </form>
            </div>
        </div>
        <jsp:include page="fragments/footer.jsp"/>
    </div>
</body>
</html>
