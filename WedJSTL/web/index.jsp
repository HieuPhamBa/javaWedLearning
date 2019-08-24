<%-- 
    Document   : index
    Created on : Aug 12, 2019, 7:45:09 AM
    Author     : PhamBaHieu
--%>

<%@page import="Model.News"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Tin nhanh</a>
        </nav>
       
        <div class="container">   
            <form method="GET" action="Search">
                <div class="form-group">
                  <label for="exampleInputEmail1">Search</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="keys">
                </div>
                <button type="submit" class="btn btn-primary">search</button>
            </form>
            <br/>
            <%News news= new News();
            news.getTitle(); %>
            <c:forEach var="item" items = "${news}">
                <div class="card">
                    <h5 class="card-title">${item.title}</h5>
                    <p class="card-text">${item.content}</p>
                    <p>Dang boi: ${item.author}</p>
                </div> 
            </c:forEach>       
            
            <br/>
            <nav aria-label="Page navigation example">
            <ul class="pagination">
                
                <c:if test="${curr==1}">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                           <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                    
                <c:forEach var="i" begin="1" end="${total}" step="1">
                    <li class="page-item">
                        <a class = "page-link" href="?page=${i}">${i}</a>
                    </li>
                </c:forEach>
                    
                <c:if test="${curr==total}">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                          <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>    
                </c:if> 
             <c:if test = "${curr<total}">
                <li class="page-item">
                    <a class="page-link" href="?page = ${curr+1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>  
             </c:if>    
            </ul>
          </nav>
        </div> 
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
