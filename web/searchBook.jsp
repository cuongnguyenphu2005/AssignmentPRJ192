<%-- 
    Document   : searchProduct
    Created on : Jul 7, 2025, 2:05:04 PM
    Author     : Cuong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Book</title>
    </head>
    <body>
        <!--Define-->
        <c:set var="resultSearch" value="${requestScope.BOOK_SEARCH_RESULT}"/>
        <c:set var="searchValue" value="${param.txtSearchProduct}"/>
        <c:set var="userInfo" value="${sessionScope.USER_INFO}"/>
        <c:set var="itemInCart" value="${sessionScope.ITEM_IN_CART}"/>
        <c:set var="countTotalQuantity" value="0"/>
        <!--End Define-->

        <!--Login, sign up or Welcome user-->
        <c:if test="${empty userInfo}"> <!--Not login yet-->
            <a href="login.html">Login</a> 
            or
            <a href="registerAccount.html">Sign up</a> 
        </c:if>

        <c:if test="${not empty userInfo}"> <!--Already login-->
            Welcome, ${userInfo.lastName} <br/>

            <form action="DispatchServlet" method="GET">
                <input type="submit" value="Log out" name="btAction" />
            </form>

            <h2>Personal</h2>

            <a href="userProfile.jsp">My profile</a><br/><br/>

            <!--Count total quantity-->
            <c:if test="${not empty itemInCart}">
                <c:forEach var="item" items="${itemInCart}">
                    <c:set var="countTotalQuantity" value="${countTotalQuantity + item.quantity}"/>
                </c:forEach>
            </c:if>
            <!--End Count total quantity-->

            <a href="userCart.jsp">View my shopping cart</a> (total ${countTotalQuantity})<br/>

        </c:if>
        <!--End Login, sign up or Welcome user-->

        <h1>Book store product</h1>

        <!--Search-->
        <form action="DispatchServlet" method="GET">
            <input type="text" name="txtSearchProduct" value="${searchValue}" placeholder="Type product name here" />
            <input type="submit" value="Search book" name="btAction" />
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

                            <!--Not login yet, login to add to cart-->
                            <c:if test="${not empty userInfo}">
                                <th>Quantity</th>
                                <th>Action</th> 
                                </c:if>
                            <!--End Not login yet, login to add to cart-->

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

                                <!--Watch book detail-->
                                <td>
                                    <c:url var="linkBookDetail" value="DispatchServlet">
                                        <c:param name="btAction" value="Take book detail"/>
                                        <c:param name="txtBookId" value="${book.bookId}"/>
                                    </c:url>
                                    <a href="${linkBookDetail}">More detail</a>
                                </td>
                                <!--End Watch book detail-->

                                <!--Not login yet, login to add to cart-->
                                <c:if test="${not empty userInfo}">
                                    <td>
                                        <input type="text" name="intQuantityChoosen" value="" placeholder="Type quantity" />
                                    </td>
                                    <td>
                                        <input type="submit" value="Add to card" name="btAction" />
                                        <input type="hidden" name="txtBookId" value="${book.bookId}" />
                                        <input type="hidden" name="txtBookName" value="${book.bookName}" />
                                        <input type="hidden" name="txtLastSearch" value="${searchValue}" />
                                    </td>
                                </c:if>
                                <!--End Not login yet, login to add to cart-->

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

        <!--Not login yet-->
        <c:if test="${empty userInfo}">
            <h3>Must Login to buy</h3>
        </c:if>
        <!--End Not login yet-->

    </c:if>
    <!--End Show result-->

</body>
</html>
