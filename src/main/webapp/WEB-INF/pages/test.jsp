<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WebAppSandBox - <%= request.getAttribute("title") %></title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h2><%= request.getAttribute("title") %></h2>
    <p>message: <%= request.getAttribute("message") %></p>
    <p>Session ID: <%= request.getSession().getId() %></p>
    <p>Cookies:</p>
    <p><% if (request.getCookies() == null) out.print("no cookies");
            else for (Cookie c: request.getCookies()) out.print(c.getName() + ": " + c.getValue() + "<br>"); %></p>
</body>
</html>
