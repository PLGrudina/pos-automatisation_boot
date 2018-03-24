<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 07.04.2017
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Kitchen</title>
    <link rel="stylesheet" type="text/css" href="/static/css/kitchenPage.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">

</head>

<div class="mainContainer">
    <table class="table" id="header">
        <tr>
            <td id="backButton">
                <a href="/"><img src="/static/img/backS.png"></a>
            </td>
            <td id="header-kitchen">Kitchen</td>

            <td id="corporation-name">Tomato code</td>
        </tr>

    </table>

    <div class="bildsContainer">

        <c:forEach items="${bills}" var="bill" varStatus="count">

        <c:url value="/kitchen" var="billUrl"/>
        <form action="${billUrl}" method="post">
            <input type="hidden" name="id" value="${bill.id}">

            <div class="bild">
                <h3 class="bildNumber">${bill.number}</h3>
                <hr class="line">
                <p class="bild-table">${bill.comment}</p>
                <hr class="line">

                <table class="bild-table">
                    <c:forEach items="${bill.dishList}" var="dish">
                        <tr>
                            <th>${dish.name}</th>
                            <th>&emsp;</th>
                            <th>${dish.weight}gr</th>
                        </tr>
                    </c:forEach>

                </table>
                <hr class="line">
                <div class="button">
                    <input type="submit" class="btn btn-success" value="Done">
                </div>
            </div>
            </c:forEach>
        </form>

    </div>
</div>

</body>
</html>
