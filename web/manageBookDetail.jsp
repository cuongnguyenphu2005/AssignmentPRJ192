<%-- 
    Document   : manageBookDetail
    Created on : Jul 9, 2025, 5:59:42 PM
    Author     : Cuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Book Detail</title>
    </head>
    <body>
        <!--Define-->
    <c:set var="bookInfo" value="${requestScope.BOOK_DETAIL}"/> <!-- Taked from TakeBookDetailServlet -->
    <!--End Define-->

    <a href="manageBook.jsp">Back to previous page</a>

    <h1>Manage Book Detail</h1>
 
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
