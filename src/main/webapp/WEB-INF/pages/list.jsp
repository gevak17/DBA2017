<%@include file="templates/header.jsp"%>

    <title>List</title>

</head>
<body style="background-color: powderblue; margin: auto; width: 40% ">
    <h1 style="text-align: center"><i> List registered users: </i></h1>
    <p style="text-align: center"> List users will be visible only authorized users </p>
    <t:authorize access="hasRole('ROLE_USER')">
        <p style="text-align: center">This is hidden text</p>
        <t:authorize access="hasRole('ROLE_ADMIN')">

            <p>admin asdasdfasfsdgsfgdfgfd</p>
        </t:authorize>
    <div style="background-color: cadetblue">
        <c:forEach items="${dtos}" var="dto">
            <table border="1" style="background-color: tomato">
                <th>${dto.userSurname}</th>
                <td>${dto.userName}</td>
                <td>${dto.userEmail}</td>
                <td>${dto.userPhoneNumber}</td>
            </table>
            <table border="1">
                <tr>
                    <th><img style="width: 60px; height: 80px;" src="${dto.userAvatar}"></th>
                </tr>
            </table>
            <table border="1" style="background-color: lawngreen">
                    <%--<td>${dto.userId}</td>--%>
                <tr>
                    <td>${dto.userP1}</td>
                    <td>${dto.userP2}</td>
                    <td>${dto.userP3}</td>
                    <td>${dto.userAtestat}</td>
                    <br>
                    <td><p>Average rating - ${(dto.userP1+dto.userP2+dto.userP3+dto.userAtestat)/4}</p></td>


                </tr>
            </table>
            <a href="/delUser-${dto.userId}">delete</a>
            <br>

        </c:forEach>

    </div>

<br>
        <t:authorize access="hasRole('ROLE_ADMIN')">
            <a href="/deleteAll" style="text-decoration: none; color: white; border: 3px black solid; background-color: black"> <strong> DELETE ALL </strong> </a>
        </t:authorize>
    </t:authorize>
</body>
</html>
