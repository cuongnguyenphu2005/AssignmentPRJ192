<%-- 
    Document   : search
    Created on : Jun 12, 2025, 3:54:23 PM
    Author     : Cuong
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@page import="java.util.List" %>
<%@page import="cuongnp.registration.RegistrationDTO" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>

    <body>
        <font color =" red">Welcome, ${sessionScope.USER_INFO.lastName}</font>
    </body>

    <h1>Search Page</h1>
    <form action="SearchLastNameServlet" method="GET">
        Search <input type="text" name="txtSearchValue" 
                      value="${param.txtSearchValue}" /><br/>
        <input type="submit" value="Search" name="btAction" />
    </form><br/>
    <%--gan, set attribute--%>
    <c:set var="searchValue" value ="${param.txtSearchValue}" />
    <c:if test="${not empty searchValue}">
        <c:set var ="result" value ="${requestScope.SEARCH_RESULT}"/>
        <c:if test="${not empty result}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Full name</th>
                        <th>Role</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${result}" varStatus="counter">
                        <tr>
                            <td>
                                ${counter.count}
                            .</td>
                            <td>
                                ${dto.username}
                            </td>
                            <td>
                                ${dto.password}
                            </td>
                            <td>
                                ${dto.lastName}
                            </td>
                            <td>
                                ${dto.isAdmin}
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
        <c:if test="${empty result}">
            <h2>
                <font color ="red">
                No record is matched!!!
                </font>
            </h2>
        </c:if>
    </c:if>
    <%--<%
    //service() -->_jspService()
    String searchValue = request.getParameter("txtSearchValue");
    if (searchValue != null){
        //dang dat o attribute cua request scope.
        //kieu du lieu list<RegistrationDTO>
        List<RegistrationDTO> result = (List<RegistrationDTO>)request.getAttribute("SEARCH_RESULT");
        if(result != null){//found
    %>
    <table border="1">
        <thead>
            <tr>
                <th>No.</th>
                <th>Username</th>
                <th>Password</th>
                <th>Last name</th>
                <th>Role</th>
            </tr>
        </thead>
        <tbody>
            <% 
                int count = 0;
                for (RegistrationDTO dto : result){
            %>
            <tr>
                <td>
                    <%= ++count %>.
                </td>
                <td>
                    <%= dto.getUsername() %>
                </td>
                <td>
                    <%= dto.getPassword() %>
                </td>
                <td>
                    <%= dto.getLastName() %>
                </td>
                <td>
                    <%= dto.isIsAdmin() %>
                </td>
            </tr>
            <%
                }//traverse dto in result
            %>
        </tbody>
    </table>

    <%
        }else { //not found 
    %>
    <h2>
        <font color ="red">
        No record is matched!!!
        </font>
    </h2>
    <%
        }
    }//having request parameters
    %>--%>
</body>
</html>
<!-- comment -->