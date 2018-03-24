<%--
  Created by IntelliJ IDEA.
  User: PavelGrudina
  Date: 20.04.2017
  Time: 2:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cashier</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="../../static/js/cashier.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/static/css/cashierPage.css">

    <style>
        @import url('https://fonts.googleapis.com/css?family=Lobster');
        @import url('https://fonts.googleapis.com/css?family=Bitter');

        #container {
            margin: 0 auto;
        }

        #nav {
            text-align: center;
            padding-top: 2%;
            width: 15%;
            float: left;
            height: 100%;
        }

        #aside {
            padding-top: 2%;
            padding-right: 2%;
            width: 24%;
            float: right;
        }

        #content {
            padding-top: 2%;
            text-align: center;
            width: 70%;
            margin: 0px;
            padding-left: 17%;
        }

        .category-button {
            border-radius: 5px;
            width: 45%;
            height: 45%;
        }

        #img {
            width: 40%;
        }

        #describe {
            width: 40%;
        }

        #price {
            width: 20%;
        }

        .dish-button {
            width: 50%;
            text-align: center;
        }

        .table-hover {
            background: white;
            width: 100%;
        }

        #pay-button {
            width: 50%;
            height: 3%;
            float: right;
            text-transform: uppercase;
        }

        #clear-button {
            height: 3%;
            text-transform: uppercase;
            color: tomato;
            float: left;
        }

        .col-md-2 {
            padding: 0px;
            width: initial;
        }
    </style>
</head>
<body>
<div class="mainContainer">
    <table class="table" id="header">
        <tr>
            <td id="backButton">
                <a href="/"><img src="/static/img/backS.png"></a>
            </td>
            <td id="header-cashier">Cashier</td>
            <td id="corporation-name">Tomato code</td>
        </tr>
    </table>
    <div id="container">
        <div id="nav" class=".col-md-3">
            <c:forEach items="${dishTypes}" var="dishType" varStatus="count">
                <input type="image" src="/static/img/${dishType}.png" class="category-button" id="${dishType}"
                       value=${dishType}>
                <p><strong>${dishType}</strong></p>
            </c:forEach>
        </div>

        <div id="aside" class=".col-md-3">
            <table class="table table-hover" id="check">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Weight</th>
                    <th>Price</th>

                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>

            <button type="submit" class="btn btn-default" id="clear-button"><strong>Clear</strong></button>
            <button type="submit" class="btn btn-success" id="pay-button"><strong>Pay</strong></button>
        </div>

        <div id="content" class="row">
            <c:forEach items="${sandwiches}" var="dish" varStatus="count">

                <table class="table-hover">
                    <tr>
                        <td id="img">
                            <input type="image" src="${dish.url}" class="dish-button" name=${dish.name}, id=${dish.id}>
                        </td>

                        <td id="describe">
                            <strong>${dish.name}</strong>

                            <p>
                                <c:forEach items="${dish.ingredients}" var="ingr">
                                    ${ingr.name} &nbsp
                                </c:forEach>
                            </p>

                        </td>

                        <td id="price"><strong>${dish.weight}g. / ${dish.price}$<strong></td>

                    </tr>
                </table>
                <br>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>