<%-- 
    Document   : bookDetail
    Created on : Jul 8, 2025, 4:15:19 PM
    Author     : Cuong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Detail</title>
    </head>
    <body>
        <!--Define-->
        <c:set var="bookInfo" value="${requestScope.BOOK_DETAIL}"/>
        <!--End Define-->
        
        <a href="searchBook.jsp">Back to previous page</a>
        
        <h1>Book Detail</h1>
        
        <!--Image of book-->
        <img src="${bookInfo.imageUrl}" width="200" />

        <!--End Image of book-->
        <table border="1" cellspacing="0" cellpadding="5">
    <tr>
        <td><b>Name</b></td>
        <td>${bookInfo.bookName}</td>
    </tr>
    <tr>
        <td><b>Author</b></td>
        <td>${bookInfo.author}</td>
    </tr>
    <tr>
        <td><b>Category</b></td>
        <td>${bookInfo.category}</td>
    </tr>
    <tr>
        <td><b>Publisher</b></td>
        <td>${bookInfo.publisher}</td>
    </tr>
    <tr>
        <td><b>Publish Year</b></td>
        <td>${bookInfo.publishYear}</td>
    </tr>
    <tr>
        <td><b>Price</b></td>
        <td>${bookInfo.price}</td>
    </tr>
    <tr>
        <td><b>Description</b></td>
        <td>${bookInfo.description}</td>
    </tr>
</table>

        
        
    </body>
</html>
