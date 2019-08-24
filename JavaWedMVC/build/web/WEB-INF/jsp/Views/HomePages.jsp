<%-- 
    Document   : HomePages
    Created on : Aug 24, 2019, 7:51:28 AM
    Author     : PhamBaHieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View data ^^!</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="../Css/Style.css">
    </head>
    <body>
        <%@include file = "Header/Header.jsp"%>

        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-8"><h2>News <b>Details</b></h2></div>
                        <div class="col-sm-4">
                            <a id ="add-new" class="btn btn-info add-new" href="./registry.html"><i class="fa fa-plus"></i> Add New</a>
                        </div>
                    </div>
                </div>
                <table class="table table-bordered" style = "width: 80%">
                    <thead>
                        <tr>
                            <th>Title</th>
                            <th>Author</th>
                            <th>Prices</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var ="item" items ="${BookLst}">
                        <td>${item.title}</td>
                        <td>${item.author}</td>
                        <td>${item.price}</td>
                        <td>
                            <a class="edit" title="Edit" data-toggle="tooltip" href="./Edit.jsp"><i class="material-icons">&#xE254;</i></a>
                            <a class="delete" title="Delete" data-toggle="tooltip" href="Delete.htm"><i class="material-icons">&#xE872;</i></a>
                        </td> </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>    

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
