<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>


<%@page import="java.util.List"%>
<%@page import="house.HouseDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>House List</title>
    </head>
  <body>
<a href="login.jsp">Login</a> |<a href="LoginController?action=logout">Logout</a>
    <h2>House List</h2>
<p>Welcome: ${sessionScope.usersession.name}</p>
    <form action="MainController" method="GET">
        <input type="text" name="keyword" value="<%= request.getParameter("keyword") != null ? request.getParameter("keyword") : "" %>">
        <input type="submit" value="Search">
    </form>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Size</th>
            <th>Status</th>
            <th>Action</th>
        </tr>

        <%
            List<HouseDTO> list = (List<HouseDTO>) request.getAttribute("houseList");
            if (list != null && !list.isEmpty()) {
                for (HouseDTO house : list) {
                    pageContext.setAttribute("house", house);
        %>
        <tr>
            <td>${house.id}</td>
            <td>${house.name}</td>
            <td>${house.description}</td>
            <td>${house.size}</td>
            <td>${house.status ? "1" : "0"}</td>
             <td>
                    <% if (house.isStatus()) { %>
                        <a href="MainController?action=delete&id=<%= house.getId() %>&keyword=${param.keyword}"
                           onclick="return confirm('Are you sure you want to delete this house?');">
                            Delete
                        </a>
                    <% } else { %>
                        Deleted
                    <% } %>
                </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5">No house found.</td>
        </tr>
        <%
            }
        %>
    </table>


</body>
</html>
