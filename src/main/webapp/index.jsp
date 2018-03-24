<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="utf-8">
    <title>Pos-Automatisation</title>
    <link rel="stylesheet" type="text/css" href="/static/css/resetCSS.css">
    <link rel="stylesheet" type="text/css" href="/static/css/style.css">

    <link rel="shortcut icon" href="#" type="image/x-icon">
</head>

<body>
<div class="wrapper">
    <div class="backFoto">
        <div class="content">
            <ul class="bmenu">
                <li>
                    <form action="/cashier" method="get">
                        <input type="submit" class="button" id="cashier-button" value="CASHIER"/>
                    </form>
                </li>
                <li>
                    <form action="/kitchen" method="get">
                        <input type="submit" class="button" id="kitchen-button" value="KITCHEN"/>
                    </form>
                </li>
                <li>
                    <form action="/administrator" method="get">
                        <input type="submit" class="button" id="admin-button" value="ADMINISTRATION"/>
                    </form>
                </li>

            </ul>
        </div>
    </div>


</div>
<div class="footer">
    <span>
      @Developed by P.G.(Tomato code company)
    </span>
</div>


</body>


</html>
