<% String pagemark = request.getAttribute("page") == null ?
        "" : (String) request.getAttribute("page"); %>

<div class="header">
    <a <%= pagemark.equals("home") ? "href=\"#\"" : "href=\"home\"" %>
            class="logo"><img src="img/logo.png" alt="logo"></a>
    <ul class="menu">
        <li><a <%= pagemark.equals("home") ?
                "class=\"active-link\" href=\"#\"" : "href=\"home\"" %> >HOME</a></li>
        <li><a <%= pagemark.equals("products") ?
                "class=\"active-link\" href=\"#\"" : "href=\"#\"" %> >PRODUCTS</a></li>
        <li><a <%= pagemark.equals("history") ?
                "class=\"active-link\" href=\"#\"" : "href=\"#\"" %> >HISTORY</a></li>
        <li><a <%= pagemark.equals("showroom") ?
                "class=\"active-link\" href=\"#\"" : "href=\"#\"" %> >SHOWROOM</a></li>
        <li><a <%= pagemark.equals("contact") ?
                "class=\"active-link\" href=\"#\"" : "href=\"#\"" %> >CONTACT</a></li>
        <li><a class="i-link" href="#"> <i class="fas fa-search"></i> </a></li>
    </ul>
</div>