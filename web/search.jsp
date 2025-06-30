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
    <form action="DispatchServlet" method="GET">
        <input type="submit" value="Logout" name="btAction" />
    </form>
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
                        <th>Delete</th>
                        <th>Update</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${result}" varStatus="counter">
                    <form action="DispatchServlet" method="POST">
                        <tr>
                            <td>
                                ${counter.count}
                                .</td>
                            <td>
                                ${dto.username}
                                <input type="hidden" name="txtUsername" 
                                       value="${dto.username}" />
                            </td>
                            <td>
                                <input type="text" name="txtPassword" 
                                       value="${dto.password}" />
                            </td>
                            <td>
                                ${dto.lastName}
                            </td>
                            <td>
                                <input type="checkbox" name="chkAdmin" value="ON" 
                                       <c:if test= "${dto.isAdmin}">
                                           checked="checked"
                                       </c:if>
                                       />

                            </td>
                            <td>
                                <c:url var="deleteLink" value="DispatchServlet">
                                    <c:param name="btAction" value="Delete"/>
                                    <c:param name="pk" value="${dto.username}"/>
                                    <c:param name="lastSearchValue" 
                                             value="${param.txtSearchValue}"/>
                                </c:url>
                                <a href="${deleteLink}">Delete</a>
                            </td>
                            <td>
                                <input type="submit" value="Update" name="btAction" />
                                <input type="hidden" name="lastSearchValue" 
                                       value="${searchValue}" />
                            </td>
                        </tr>
                    </form>
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