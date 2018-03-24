<%--
  Created by IntelliJ IDEA.
  User: Man
  Date: 31.03.2017
  Time: 1:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Check</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/static/css/cashierPage.css">

    <style>
        @import url('https://fonts.googleapis.com/css?family=Lobster');
        @import url('https://fonts.googleapis.com/css?family=Bitter');

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

        #priceToPay {
            font-size: x-large;
            float: right;
        }

        #comment {
            margin-top: 2%;
            margin-bottom: 5%;
            float: left;
            width: 100%;
        }



    </style>

</head>
<body>

<table class="table table-hover" id="check">
    <thead>
    <tr>
        <th>Title</th>
        <th>Weight</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${dishList}" var="dish">
        <tr>
            <td>${dish.name}</td>
            <td>${dish.weight}</td>
            <td>${dish.price}</td>
        </tr>
    </c:forEach>
    </thead>
    <tbody>

    </tbody>
</table>

<hr>
<p id="priceToPay"><strong>${price}$</strong></p>


<c:url value="/check" var="createBill"/>
<form action="${createBill}" method="post">

    <input id="comment" type="text" name="comment">

    <button type="submit" class="btn btn-default" id="clear-button" name="doButton" value="CLEAR"><strong>Clear</strong>
    </button>
    <button type="submit" class="btn btn-success" id="pay-button" name="doButton" value="CREATE"><strong>Pay</strong>
    </button>
</form>
</body>
</html>
