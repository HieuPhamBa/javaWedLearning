<%-- 
    Document   : Edit
    Created on : Jul 29, 2019, 7:33:15 AM
    Author     : PhamBaHieu
--%>

<%@page import="java.sql.*" %>
<%@page import="User.UserModel"%>
<%@page import="User.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="./Css/StyleRegistry.css">
      
    </head>
    <body>
       
        <div class="col-md-4 col-md-offset-4" id="login">
        <section id="inner-wrapper" class="login">
            <article>
                <form method = "POST" action=<%="Edit"%>>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"> </i></span>
                            <input type="text" class="form-control" placeholder="Name" name="name" id ="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope"> </i></span>
                            <input type="email" class="form-control" placeholder="Email Address" name ="email" id = "mail">
                        </div>
                    </div>
                    <div class="form-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <div class="input-group">
                            <input type="password" class="form-control" placeholder="Password" name="pass" id = "pass">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon" name = "id"><i class="fa fa-key"> </i></span>
                            <input type="password" class="form-control" placeholder="Confirm Password" name="comfir-pass" id="comfir-pass">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-success btn-block">Save</button>
                    <a  href="./index.jsp" class="btn btn-success btn-block">Cancel</a>
                </form>
            </article>
        </section></div>
        <script>
               window.onload = function(){
                   var name = document.getElementById("name");
                   var pass = document.getElementById("pass");
                   var comfir_pass = document.getElementById("comfir-pass");
                   var email = document.getElementById("email");
                   <% 
                       try{
                            User us = new User();
                            us = (User)session.getAttribute("user");   
           
                   %>
                    name.value = '<%= us.getName()%>';
                    comfir_pass.value =  pass.value = '<%=us.getPass()%>';
                    email.value = '<%= us.getEmail()%>';
                    <%
                           }catch(Exception e){
                           out.print(e.toString());
                       }
                        
                    %>
               }                  
        </script>
            
    </body>
</html>
