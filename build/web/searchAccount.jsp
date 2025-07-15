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
        <title>Search account</title>
    </head>

    <body>

        <!--Define-->
        <c:set var="adminInfo" value="${sessionScope.ADMIN_INFO}"/>
        <c:set var="searchValue" value ="${param.txtSearchValue}" />
        <c:set var ="result" value ="${requestScope.SEARCH_RESULT}"/>
        <!--End Define-->

        <font color =" red">Welcome, ${adminInfo.lastName}</font>

        <!--Logout-->
        <form action="DispatchServlet" method="GET">
            <input type="submit" value="Log out" name="btAction" />
        </form>
        <!--End Logout-->

        <!--Security-->
        <c:if test="${not empty adminInfo}"> 

            <!--Menu-->
            <h2>Menu</h2>

            <!--Manage Book items-->
            <a href="manageBook.html">Manage book items</a><br/><br/>
            <!--End Manage Book items-->

            <!--User order-->
            <a href="manageOrder.html">Manage order</a><br/>
            <!--End User order-->

            <!--End Menu-->

            <h1>Search Page</h1>

            <!--Search-->
            <form action="DispatchServlet" method="GET">
                <input type="text" name="txtSearchValue" 
                       value="${searchValue}" placeholder="Type account name here"/>
                <input type="submit" value="Search" name="btAction" />
            </form><br/>
            <!--End Search-->

            <%--gan, set attribute--%> <!-- Show result-->
            <c:if test="${not empty searchValue}">
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
                                        ${counter.count}.
                                    </td>
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
                                               <c:if test= "${dto.role}">
                                                   checked="checked"
                                               </c:if>
                                               />

                                    </td>

                                    <!--Delete link-->
                                    <td>
                                        <c:url var="deleteLink" value="DispatchServlet">
                                            <c:param name="btAction" value="Delete"/>
                                            <c:param name="pk" value="${dto.username}"/>
                                            <c:param name="lastSearchValue" 
                                                     value="${searchValue}"/>
                                        </c:url>
                                        <a href="${deleteLink}">Delete</a>
                                    </td>
                                    <!--End Delete link-->

                                    <!--Update-->
                                    <td>
                                        <input type="submit" value="Update" name="btAction" />
                                        <input type="hidden" name="lastSearchValue" 
                                               value="${searchValue}" />
                                    </td>
                                    <!--End Update-->

                                </tr>
                            </form>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <!--Result null-->
            <c:if test="${empty result}">
                <h2>
                    <font color ="red">
                    No record is matched!!!
                    </font>
                </h2>
            </c:if>
            <!--End Result null-->

        </c:if>
        <!-- End Show result-->

    </c:if>
    <!--End Security-->

</body>
</html>
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

<!-- comment -->