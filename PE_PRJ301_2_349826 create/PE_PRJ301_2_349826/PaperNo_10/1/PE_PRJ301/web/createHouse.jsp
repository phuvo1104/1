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

<a href="login.jsp">Login</a> | <a href="LoginController?action=logout">Logout</a>

<h2>House List</h2>
<p>Welcome: ${sessionScope.usersession.name}</p>

<!-- Nút tạo mới -->
<p><a href="MainController?action=create">Create New House</a></p>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>price</th>
        <th>Size</th>
        <th>Status</th>
    </tr>

    <%
        List<HouseDTO> list = (List<HouseDTO>) request.getAttribute("createHouse");
        if (list != null && !list.isEmpty()) {
            for (HouseDTO house : list) {
                pageContext.setAttribute("house", house);
    %>
    <tr>
        <td>${house.id}</td>
        <td>${house.name}</td>
        <td>${house.description}</td>
        <td>${house.price}</td>
        <td>${house.size}</td>
        <td>${house.status ? "1" : "0"}</td>
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
