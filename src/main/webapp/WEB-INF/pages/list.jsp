<%@include file="templates/header.jsp"%>

    <title>List</title>

</head>
<body style="background-color: powderblue; margin: auto; width: 30% ">
    <h1><i> List registered users: </i></h1>

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

            <br>

        </c:forEach>

    </div>

<br>

<a href="/deleteAll" style="text-decoration: none; color: white; border: 3px black solid; background-color: black"> <strong> DELETE ALL </strong> </a>

</body>
</html>
