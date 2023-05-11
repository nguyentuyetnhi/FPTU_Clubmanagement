<%-- 
    Document   : list
    Created on : Feb 27, 2023, 10:53:02 AM
    Author     : ACER NITRO 5
--%>
<%@ include file="/includes/header.jsp" %>
<%@page import="Model.Club"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Club</title>
        <style>
            table{
                border-collapse: collapse;
            }
            td{
                padding: 10px;
            }
        </style>
        <script type="text/javascript">
            function doDelete(id){
                if(confirm("Are you sure to delete the club with id ="+id+"?")){
                    window.location="delete?id="+id;
                }
            }
        </script>
    </head>
    <body>
        <h1>List of Club</h1>
        <h3><a href="new.jsp"> Add New Club</a></h3>
        <table border ="1px">
            <tr>
                <th>ID</th>
                <th>LOGO</th>
                <th>NAME</th>
                <th>ACTION</th>
            </tr>
            <%
                List<Club> list=(List<Club>) request.getAttribute("data");
                for(Club c: list){
                    String id = c.getClubId();
            %>
            <tr>
                <td><%= id %></td>
                <td><img src="<%= c.getClubLogo() %>" width="100px" height="100px"></td>
                <td><%= c.getClubName() %></td>
                <td>
                    <a href="joined-student?id=<%= id %>">View Members</a>&nbsp;&nbsp;&nbsp;
                    <a href="update-club?id=<%= id %>">Update</a>&nbsp;&nbsp;&nbsp;
                    <a href="#" onclick="doDelete('<%= id %>')"> Delete</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>

<%@ include file="/includes/footer.jsp" %>