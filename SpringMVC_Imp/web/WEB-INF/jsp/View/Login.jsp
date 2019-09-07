<%-- 
    Document   : Login
    Created on : Aug 21, 2019, 1:05:21 PM
    Author     : PhamBaHieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri = "http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>

        <nav class="navbar navbar-dark bg-primary" style = " margin-bottom: 5%">
             <span class="navbar-brand mb-0 h1">Login</span>
        </nav>
        ${err}
        <div class ="container" style = "width: 50%">          
            <form:form method="POST" action="auth.htm" modelAttribute="UserLogin">
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <form:input type="email" class="form-control" id="txtEmail1" path ="email" aria-describedby="emailHelp" />
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <form:password class="form-control" id="txtPass" path = "pass"/>
                </div>
                <form:button type="submit" class="btn btn-primary">Submit</form:button>
              
            </form:form>
        </div>
        <script>
            window.onload = function bindControl(){
                var txtEmail = document.getElementById('txtEmail1');
                var txtPass = document.getElementById('txtPass');
                txtEmail.value = '${cookie.UserEmail.value}';
                txtPass.value = '${cookie.UserPass.value}';
            }
        </script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
