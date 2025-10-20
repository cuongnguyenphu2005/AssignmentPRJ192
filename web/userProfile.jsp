<%-- 
    Document   : userProfile
    Created on : Jul 8, 2025, 1:49:15 PM
    Author     : Cuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My profile</title>
    </head>
    <body>
        <!--Define-->
        <c:set var="userInfor" value="${sessionScope.USER_INFO}"/>
        <!--End Define-->

        <a href="searchBook.jsp">Back to Search Book page</a>

        <h1>My profile</h1>

        <form action="DispatchServlet" method="POST">
            Username <input type="text" name="" value="${userInfor.username}" readonly="readonly" /> <br/>
            Name‎ ‎ ‎ ‎ ‎ ‎ ‎  <input type="text" name="" value="${userInfor.lastName}" /><br/>

<!--            <h3>Contact information</h3>
            Address <input type="text" name="txtUserAddress" value="" />
            <a href="">Edit</a><br/>

            Phone <input type="text" name="txtUserPhone" value="" />
            <a href="">Edit</a><br/>

            Email <input type="text" name="txtUserEmail" value="" />
            <a href="">Edit</a><br/><br/>
            <input type="submit" value="Save my information" name="btAction" />-->
        </form>

            
        <h3>History order</h3>
        <c:if test="${empty requestScope.USER_HISTORY_ORDERS}">
            You don't have any order yet! 
        </c:if>
            
    </body>
</html>
