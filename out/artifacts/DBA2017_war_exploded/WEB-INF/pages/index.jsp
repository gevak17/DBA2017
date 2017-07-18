<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<html>
<head>
    <title>Welcome</title>
</head>
<body style="background: silver" class="">
    <h1> Hello !!!</h1>
    <br>
    <%--<form action="/" method="post">--%>
        <%--<input type="text">--%>
        <%--<input type="submit">--%>
    <%--</form>--%>

    <%--${xxx}--%>
    <div style="width: 30%;background-color: darkgray">
        <sf:form action="addNewUser" method="post" modelAttribute="user" enctype="multipart/form-data">
            <div>
                <p>Enter your surname</p>
                <sf:input path="surName" placeholder = "Enter your surname..." autocomplete="off"/>
                <sf:errors path="surName"/>
                <p>Enter your name</p>
                <sf:input path="name" placeholder = "Enter your name..." autocomplete="off"/>
                <sf:errors path="name"/>
            </div>
            <p>Enter your rating 1 </p><sf:input path="p1" type="number" min="100" max="200" step="1" value="100"/>
            <sf:errors path="p1"/>
            <p>Enter your rating 2 </p><sf:input path="p2" type="number" min="100" max="200" step="1" value="100"/>
            <sf:errors path="p2"/>
            <p>Enter your rating 3 </p><sf:input path="p3" type="number" min="100" max="200" step="1" value="100"/>
            <sf:errors path="p3"/>
            <p>Enter your Atestat's rating </p><sf:input path="atestat" type="number" min="100" max="200" step="1" value="100"/>
            <sf:errors path="atestat"/>
            <br><br>
            <input type="file" name="ava">
            <input type="submit">
        </sf:form>
    </div>

    <br>
    <a href="/list" style="text-decoration: none; color: white; border: 3px black solid;
    background-color: black"> <strong> List </strong> </a>


</body>
</html>
