<%-- 
    Document   : createNewAccount
    Created on : Jun 30, 2025, 4:00:27 PM
    Author     : Cuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up</title>
    </head>
    <body>
        <h1>Register</h1>
        <form name="DispatchServlet" method="POST">
            <c:set var = "errors" value ="${requestScope.CREATE_ERROR}"/>

            Username* <input type="text" name="txtUsername" 
                             value="${param.txtUsername}" /> (6 - 12 chars)<br/>
            <c:if test ="${not empty errors.usernameLengthErr}">
                <font color ="red">
                ${errors.usernameLengthErr}
                </font><br/>
            </c:if>
            <c:if test ="${not empty errors.usernameIsExisted}">
                <font color ="red">
                ${errors.usernameIsExisted}
                </font><br/>
            </c:if>
            Password* <input type="password" name="txtPassword" value="" /> (8 - 12 chars)<br/>
            <c:if test ="${not empty errors.passwordLengthErr}">
                <font color ="red">
                ${errors.passwordLengthErr}
                </font><br/>
            </c:if>
            Confirm* <input type="password" name="txtConfirm" value="" /><br/>
            <c:if test ="${not empty errors.confirmNotMatched}">
                <font color ="red">
                ${errors.confirmNotMatched}
                </font><br/>
            </c:if>
            Full name* <input type="text" name="txtFullname" 
                              value="${param.txtFullname}"/> (2 - 40 chars)<br/>
            <c:if test ="${not empty errors.fullnameLengthErr}">
                <font color ="red">
                ${errors.fullnameLengthErr}
                </font><br/>
            </c:if>
            <input type="submit" value="Sign up" name="btAction" />
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>
