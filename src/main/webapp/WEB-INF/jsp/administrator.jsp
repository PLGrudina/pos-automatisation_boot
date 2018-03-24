<%--
  Created by IntelliJ IDEA.
  User: PavelGrudina
  Date: 05.04.2017
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Administrator</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/static/css/adminPage.css">

</head>
<body>
<div id="mainContainer">
    <table class="table" id="header">
        <tr>
            <td id="backButton">
                <a href="/"><img src="/static/img/backS.png"></a>
            </td>
            <td id="header-admin">Administrator</td>

            <td id="corporation-name">Tomato code</td>
        </tr>

    </table>

    <table id="tableWraper">
        <tr>
            <td id="containerDish">
                <table class="table">
                    <tr>
                        <td>Dishes

                            <c:url value="/dish" var="createDish"/>
                            <a href="${createDish}" class="btn btn-success" role="button">Add new Dish</a><br>

                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>№</th>
                                    <th>Name</th>
                                    <th>Weight</th>
                                    <th>Price</th>
                                    <th class="center">Remove</th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${dishList}" var="dish" varStatus="count">
                                <tr>
                                    <th scope="row">${count.index + 1}</th>
                                    <td>
                                        <c:url value="/dish?id=${dish.id}" var="DishUrl"/>
                                        <a href="${DishUrl}">${dish.name}</a>
                                    </td>
                                    <td>${dish.weight}</td>
                                    <td>${dish.price}</td>

                                    <td class="center">
                                        <c:url value="/administrator" var="deleteUrl"/>
                                        <form action="${deleteUrl}" method="post">
                                            <input type="image" src="/static/img/delete.png" class="delete-button" name="id" value="${dish.id}">
                                        </form>
                                    </td>

                                </tr>
                                </c:forEach>
                            </table>
                        </td>

                    </tr>
                </table>
            </td>

            <td id="containerIngr">
                <table class="table">
                    <tr>
                        <td>Ingredients

                            <c:url value="/ingredient" var="createUrl"/>
                            <a href="${createUrl}" class="btn btn-success" role="button">Add new Ingredient</a><br>

                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>№</th>
                                    <th>Name</th>
                                    <th>Weight</th>
                                    <th>Date</th>
                                    <th>Status</th>
                                    <th class="center">Remove</th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${ingredientList}" var="ingredient" varStatus="count">
                                <tr>
                                    <th scope="row">${count.index + 1}</th>
                                    <td>
                                        <c:url value="/ingredient?id=${ingredient.id}" var="IngredientUrl"/>
                                        <a href="${IngredientUrl}">${ingredient.name}</a>
                                    </td>
                                    <td>${ingredient.weight}</td>
                                    <td>${ingredient.date}</td>
                                    <td>${administratorService.getIngredientStatus(ingredient)}</td>

                                    <td class="center">
                                        <c:url value="/administrator" var="deleteUrl"/>
                                        <form action="${deleteUrl}" method="post">
                                            <input type="image" src="/static/img/delete.png" class="delete-button" name="id" value="${ingredient.id}">
                                        </form>
                                    </td>


                                </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>

<div id="up">
    <a href="#header">
        <img src="/static/img/up.png">
    </a>
</div>

</body>
</html>
