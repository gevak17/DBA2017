<%@include file="templates/header.jsp"%>

    <title>Welcome</title>

</head>
<body style="margin: auto; width: 40%; padding-bottom: 50px">
    <h1 style="text-align: center"> Hello to registration page </h1>
    <%--<br>--%>
    <%--<form action="/" method="post">--%>
        <%--<input type="text">--%>
        <%--<input type="submit">--%>
    <%--</form>--%>

    <%--${xxx}--%>
    <div style="background-color: darkgray; width: 80%; padding-left: 20px; padding-bottom: 20px">
        <sf:form action="addNewUser" method="post" modelAttribute="user" enctype="multipart/form-data">
            <br>
            <sf:input path="surName" placeholder = "Enter your surname..." autocomplete="off"/>
            <sf:errors path="surName"/>

            <sf:input path="name" placeholder = "Enter your name..." autocomplete="off"/>
            <sf:errors path="name"/>
            <sf:input path="username" placeholder="Enter login" autocomplete="off"/>
            <sf:input path="password" placeholder="Enter password" autocomplete="off"/>
            <sf:input type="email" path="email" placeholder="Enter email" autocomplete="off"/>
            <sf:input path="phoneNumber" placeholder = "Enter your phone number..." autocomplete="off"/>

            <p>Enter your rating 1 </p><sf:input path="p1" type="number" min="100" max="200" step="1" value="100"/>
            <sf:errors path="p1"/>
            <p>Enter your rating 2 </p><sf:input path="p2" type="number" min="100" max="200" step="1" value="100"/>
            <sf:errors path="p2"/>
            <p>Enter your rating 3 </p><sf:input path="p3" type="number" min="100" max="200" step="1" value="100"/>
            <sf:errors path="p3"/>
            <p>Enter your Atestat's rating </p><sf:input path="atestat" type="number" min="100" max="200" step="1" value="100"/>
            <sf:errors path="atestat"/>
            <br><br>
            <p>Enter your photo</p><input type="file" name="ava">
            <input type="reset" value="Reset">
            <input type="submit">
        </sf:form>
    </div>


    <%--<a href="/list" style="text-decoration: none; color: white; border: 3px black solid;--%>
    <%--background-color: black"> <strong> List </strong> </a>--%>


</body>
</html>
