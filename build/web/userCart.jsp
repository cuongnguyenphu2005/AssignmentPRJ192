<%-- 
    Document   : userCart
    Created on : Jul 8, 2025, 1:46:58 PM
    Author     : Cuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My cart</title>
    </head>
    <body>
        <!--Define-->
        <c:set var="itemInCart" value="${sessionScope.ITEM_IN_CART}"/>
        <c:set var="userInfo" value="${sessionScope.USER_INFO}"/>
        <c:set var="countQuantity" value="${0}"/>
        <c:set var="finalPrice" value="0"/>
        <!--End Define-->

        <a href="searchBook.jsp">Back to Search Book page</a>

        <h1>My cart</h1>

        <!--Show result search-->
        <c:if test="${not empty itemInCart}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Name</th>
                        <th>Price(VND)</th>
                        <th>Quantity</th>
                        <th>Total Price(VND)</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${itemInCart}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.bookName}</td>
                            <td>${dto.price} </td>
                            <td>
                                ${dto.quantity}
                                <c:set var="countQuantity" value="${countQuantity + dto.quantity}"/>
                            </td>
                            <td>
                                ${dto.totalPrice} 
                                <c:set var="finalPrice" value="${finalPrice+ dto.totalPrice}"/>
                            </td>

                            <!--Button remove item-->
                            <td>
                                <form action="DispatchServlet" method="POST">
                                    <input type="submit" value="Remove item(s)" name="btAction" />
                                    <input type="hidden" name="txtBookId" value="${dto.bookId}" />
                                </form>
                            </td>
                            <!--End Button remove item-->

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty itemInCart}">
            <h2>No Product Yet!</h2>
        </c:if>
        <!--End Show result search-->
        <a href="searchBook.jsp">Take more book(s)</a>
        <!--Total cost-->
        <h3>Total (${countQuantity} item(s)): ${finalPrice} VND</h3>  
        <!--End Total cost-->

        <!--Contact Information-->
        <h2>Contact Information</h2>
        <form action="DispatchServlet" method="POST">
            Phone‎ ‎ ‎ ‎ ‎<input type="text" name="intPhone" value="" placeholder="Type your phone here"/><br/><br/>
            Address <input type="text" name="txtAddress" value="" placeholder="Type your address here"/><br/><br/>
            <!--End Contact Information-->

            <!--Button Check Out-->
            <input type="submit" value="Check Out" name="btAction" />
            
        </form>
        <!--End Button Check Out-->


    </body>
</html>
