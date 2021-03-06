<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Pos-Automatisation</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="shortcut icon" href="#" type="image/x-icon">
</head>

<body>

<div class="wrapper">

    <div class="row">

        <div class="col-md-offset-3 col-md-6">
            <#if error>
                <div class="alert alert-danger" role="alert">Invalid Username or Password!</div>
            </#if>

            <form class="form-horizontal" method="post">
                <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">

                <span class="heading">Sign in</span>
                <div class="form-group">
                    <input type="text" class="form-control" id="inputEmail" placeholder="E-mail" name="username">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="password">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <#--<div class="main-checkbox">-->
                        <#--<input type="checkbox" value="none" id="checkbox1" name="check"/>-->
                        <#--<label for="checkbox1"></label>-->
                    <#--</div>-->
                    <span class="text">
                        <a href="/registration">Register new account</a>
                    </span>
                    <button type="submit" class="btn btn-default">Sign in</button>
                </div>
            </form>
        </div>

    </div>

    <div class="footer">
    <span>
      @Developed by P.G.(Tomato code company)
    </span>
    </div>

</div>

</body>

</html>
