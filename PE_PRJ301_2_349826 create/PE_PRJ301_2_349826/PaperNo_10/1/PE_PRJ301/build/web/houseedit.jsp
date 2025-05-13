<%@ page contentType="text/html;charset=UTF-8" %>
<%
    house.HouseDTO house = (house.HouseDTO) request.getAttribute("house");
    String nextaction = (String) request.getAttribute("nextaction");
%>
<html>
<head><title>Edit House</title></head>
<body>
    <h2>House Information</h2>
    <form action="MainController" method="post">
        <input type="hidden" name="action" value="<%= nextaction %>"/>

        ID: <input type="text" name="id" value="<%= house.getId() != null ? house.getId() : "" %>" /><br/>
        Name: <input type="text" name="name" value="<%= house.getName() != null ? house.getName() : "" %>" /><br/>
        Description: <input type="text" name="description" value="<%= house.getDescription() != null ? house.getDescription() : "" %>" /><br/>
        Size: <input type="text" name="size" value="<%= house.getSize() %>" /><br/>
        
        <!-- Trường giá trị price -->
        Price: <input type="text" name="price" value="<%= house.getPrice() %>" /><br/>

        <!-- Ẩn trường status luôn là true -->
        <input type="hidden" name="status" value="true" />

        <input type="submit" value="Save"/>
    </form>
</body>
</html>
