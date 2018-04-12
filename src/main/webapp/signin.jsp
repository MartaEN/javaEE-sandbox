<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>WebAppSandBox - Авторизация</title>
        <link rel="stylesheet" href="styles.css">
        <script defer src="https://use.fontawesome.com/releases/v5.0.9/js/all.js"
                integrity="sha384-8iPTk2s/jMVj81dnzb/iFR2sdA7u06vHJyyLlAd4snFpCl/SnyUjRrbdJsw1pGIl"
                crossorigin="anonymous">
        </script>
    </head>
    <body>
        <ul class="menu">
            <li><a href="main">Главная</a></li>
            <li><a href="catalog">Каталог</a></li>
            <li><a href="cart">Корзина</a></li>
            <li><a href="orders">Заказы</a></li>
            <li><a href=<%= request.getAttribute("auth-link") %>><i class="fas fa-user-circle"></i> <%= request.getAttribute("auth-text") %></a></li>
        </ul>
        <main>
            <form method="post" action="sign-in">
                Введите (любое) имя пользователя: <br>
                <input name="username" required/>
                <input type="submit" value="Войти"/>
            </form>
        </main>
    </body>
</html>
