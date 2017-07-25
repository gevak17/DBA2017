<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/style.css">

    <style>
        /*body{*/
            /*margin: auto;*/
            /*background: skyblue;*/
        /*}*/


    </style>
    <div style="width: 100%; height: 50px; background: black; padding:50px">
        <ul style="display: block;">
            <li style="display:inline;  background: ghostwhite; border: 1px solid white; padding: 4px; border-radius: 5px"><a href="/">Головна сторінка</a></li>
            <li style="display:inline;  background: ghostwhite; border: 1px solid white; padding: 4px; border-radius: 5px"><a href="/index">Реєстрація</a></li>
            <li style="display:inline;  background: ghostwhite; border: 1px solid white; padding: 4px; border-radius: 5px"><a href="/list">Заєристровані користувачі</a></li>
            <li style="display:inline;  background: chartreuse; border: 1px solid white; padding: 4px; border-radius: 10px"><a href="/login">Вхід</a></li>
            <t:authorize access="hasRole('ROLE_USER')">
                <li style="display:inline;  background: red; border: 1px solid white; padding: 4px; border-radius: 10px"><a href="/logout">Вихід</a></li>
            </t:authorize>


        </ul>
    </div>
    <%--nav{--%>
    <%--display: block;--%>
    <%--}--%>

    <%--.menu {--%>
    <%--padding-left:10px;--%>
    <%--}--%>
    <%--.menu ul {--%>
    <%--list-style:none;--%>
    <%--}--%>
    <%--.menu li {--%>

    <%--}--%>