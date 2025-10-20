<%-- 
    Document   : manageBook
    Created on : Jul 9, 2025, 5:21:28 PM
    Author     : Cuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage book</title>
    </head>
    <body>
        <!--Define-->
    <c:set var="adminInfo" value="${sessionScope.ADMIN_INFO}"/>
    <c:set var="resultSearch" value="${requestScope.BOOK_SEARCH_ADMIN_RESULT}"/>
    <c:set var="searchValue" value="${param.txtSearchBookManage}"/>
    <!--End Define-->

    <a href="searchAccount.jsp">Back to Search Account page</a>
    
    <h1>Manage book</h1>

    <!--Search-->
    <form action="DispatchServlet" method="GET">
        <input type="text" name="txtSearchBookManage" value="${searchValue}" placeholder="Type book name here" />
        <input type="submit" value="Find book" name="btAction" />
    </form><br/>
    <!--End Search-->

    <!--Show result-->
    <c:if test="${not empty searchValue}">
        <c:if test="${not empty resultSearch}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Name</th>
                        <th>Author</th>
                        <th>Category</th>
                        <th>Publish Year</th>
                        <th>Price(VND)</th>
                        <th>Extend</th>
                    </tr>
                </thead>

                <tbody>
                <c:forEach var="book" items="${resultSearch}" varStatus="counter">
                    <form action="DispatchServlet" method="POST">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${book.bookName}</td>
                            <td>${book.author}</td>
                            <td>${book.category}</td>
                            <td>${book.publishYear}</td>
                            <td>${book.price}</td>
                            <td>
                        <c:url var="linkBookDetail" value="DispatchServlet">
                            <c:param name="btAction" value="Take book detail"/>
                            <c:param name="txtBookId" value="${book.bookId}"/>
                            <c:param name="adminRequest" value="${adminInfo}"/>
                        </c:url>
                        <a href="${linkBookDetail}">More detail</a>
                        </td>
                        </tr>
                    </form>
                </c:forEach>
                </tbody>

            </table>
        </c:if>

        <!--Empty result-->
        <c:if test="${empty resultSearch}">
            Not found any book name contain "${searchValue}"
        </c:if><br/>
        <!--End Empty result-->

    </c:if>
    <!--End Show result-->
</body>
</html>
