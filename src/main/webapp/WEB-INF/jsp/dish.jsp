<%--
  Created by IntelliJ IDEA.
  User: PavelGrudina
  Date: 09.04.2017
  Time: 2:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Administrator</title>
    <link rel="stylesheet" type="text/css" href="/static/css/adminPage.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<div id="mainContainer">
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
            <h3>Edit dish:</h3>

            <c:url value="/dish" var="editUrl"/>
            <form action="${editUrl}" method="post">

                <input type="hidden" name="id" value="${dish.id}">

                <div class="form-group">
                    <label for="name">Name:</label>
                    <input id="name" type="text" class="form-control" name="name" value="${dish.name}">
                </div>

                <div class="form-group">
                    <label for="categorySANDWICH">Category:</label>
                    <input id="categorySANDWICH" type="radio" name="category"
                           value="SANDWICH" ${dish.category == "SANDWICH" ? "checked" : ""}/>SANDWICH
                    <input id="categorySNACK" type="radio" name="category"
                           value="SNACK" ${dish.category == "SNACK" ? "checked" : ""}/>SNACK
                    <input id="categorySALAD" type="radio" name="category"
                           value="SALAD" ${dish.category == "SALAD" ? "checked" : ""}/>SALAD
                    <input id="categoryDESSERT" type="radio" name="category"
                           value="DESSERT" ${dish.category == "DESSERT" ? "checked" : ""}/>DESSERT
                    <input id="categoryDRINK" type="radio" name="category"
                           value="DRINK" ${dish.category == "DRINK" ? "checked" : ""}/>DRINK
                </div>

                <div class="form-group">
                    <label for="weight">Weight:</label>
                    <input id="weight" type="text" class="form-control" name="weight" value="${dish.weight}">
                </div>

                <div class="form-group">
                    <label for="price">Price:</label>
                    <input id="price" type="text" class="form-control" name="price" value="${dish.price}">
                </div>

                <div class="form-group">
                    <label for="url">Photo URL:</label>
                    <input id="url" type="text" name="url" value="${dish.url}">
                </div>

                <div class="form-group">
                    <input type="hidden" name="ingredientName[]" value="">

                    <c:forEach items="${dish.ingredients}" var="dishIngr">
                        <tr>
                            <input id="ingredient" type="checkbox" checked name="ingredientName[]"
                                   value="${dishIngr.name}"/>${dishIngr.name}
                        </tr>
                        <br>
                    </c:forEach>

                    <c:forEach items="${ingredientList}" var="ingredient" varStatus="count">
                        <tr>

                            <input id="ingredient" type="checkbox" name="ingredientName[]"
                                   value="${ingredient.name}"/>${ingredient.name}
                        </tr>
                        <br>

                    </c:forEach>

                </div>


                <input type="submit" class="btn btn-success" value="Submit">
            </form>
        </div>
    </div>

</div>

</body>
</html>
