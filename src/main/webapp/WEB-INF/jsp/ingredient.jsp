<%--
  Created by IntelliJ IDEA.
  User: PavelGrudina
  Date: 09.04.2017
  Time: 2:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ingredient</title>
    <link rel="stylesheet" type="text/css" href="/static/css/adminPage.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>

<div class="mainContainer">

    <table class="table" id="header">
        <tr>
            <td id="backButton">
                <a href="/administrator"><img src="/static/img/backS.png"></a>
            </td>
            <td id="header-admin">Administrator</td>

            <td id="corporation-name">Tomato code</td>
        </tr>

    </table>

    <div class="container">
        <div class="col-xs-4 centered">
            <h3>Edit ingredient:</h3>

            <c:url value="/ingredient" var="editUrl"/>
            <form action="${editUrl}" method="post">

                <input type="hidden" name="id" value="${ingredient.id}">

                <div class="form-group">
                    <label for="name">Name:</label>
                    <input id="name" type="text" class="form-control" name="name" value="${ingredient.name}">
                </div>

                <div class="form-group">
                    <label for="weight">Weight:</label>
                    <input id="weight" type="text" class="form-control" name="weight" value="${ingredient.weight}">
                </div>

                <div class="form-group">
                    <label for="date">Date:</label>
                    <input id="date" type="date" name="date" value="${ingredient.date}">
                </div>

                <input type="submit" class="btn btn-success" value="Submit">
            </form>
        </div>
    </div>
</div>

</body>
</html>
