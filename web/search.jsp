<%-- 
    Document   : search
    Created on : Jun 12, 2025, 3:54:23 PM
    Author     : Cuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="cuongnp.registration.RegistrationDTO" %>
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
        Search <input type="text" name="txtSearchname" 
                      value="<%= request.getParameter("txtSearchname") %>" /><br/>
        <input type="submit" value="Search" name="btAction" />
    </form>
    <%
    //service() -->_jspService()
    String searchValue = request.getParameter("txtSearchname");
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
    %>
</body>
</html>
<!-- comment -->