<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
    <script src="../../static/js/cashier.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/static/css/cashierPage.css">

    <style>
        @import url('https://fonts.googleapis.com/css?family=Lobster');
        @import url('https://fonts.googleapis.com/css?family=Bitter');

        #container {
            margin: 0 auto;
        }

        #content {
            padding-top: 1.2%;
            text-align: center;
            width: 83%;
            margin: 0px;
            padding-left: 10%;
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

    </style>
</head>
<body>
<div id="container">
<div id="content" class="row">
    <c:forEach items="${dishes}" var="dish" varStatus="count">
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
</body>
</html>
