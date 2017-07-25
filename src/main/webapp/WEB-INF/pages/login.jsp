<%@include file="templates/header.jsp"%>

    <title>Login</title>

</head>
<body style="margin: auto; width: 40%">
    <h1 style="text-align: center">Login page</h1>
    <form action="/login" method="post">
        <br>
        <input type="text" placeholder="Enter your login..." name="username">
        <input type="password" placeholder="Enter your password..." name="password">
        <input type="submit" value="Sign in">
        <input type="hidden"
        	name="${_csrf.parameterName}"
        	value="${_csrf.token}"/>
        <br>
    </form>

    <%--<a href="/" style="text-decoration: none; color: white; border: 3px black solid; background-color: black"> <strong> Main page </strong> </a>--%>
    <%--<a href="/index" style="text-decoration: none; color: white; border: 3px black solid; background-color: black"> <strong> to registration</strong> </a>--%>
</body>
</html>
