<%-- 
    Document   : list_joined_club
    Created on : Mar 1, 2023, 7:41:39 AM
    Author     : ACER NITRO 5
--%>
<%@ include file="/includes/header.jsp" %>
<%@page import="java.util.List"%>
<%@page import="Model.Club"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Joined Club</title>
        <style>
            table{
                border-collapse: collapse;
            }
            td{
                padding: 10px;
            }
        </style>
        <script type="text/javascript">
            function doDeleteJoinedClub(clubId, studentId){
                if(confirm("Are you sure to leave the club with id ="+clubId+"?")){
                    window.location="delete-joined-club?club-id="+clubId+"&student-id="+studentId;
                }
            }
        </script>
    </head>
    <body>
        <h1>List of Club</h1>
        <% 
            List<Club> list=(List<Club>) request.getAttribute("data");
            String studentId = (String) request.getAttribute("studentId");
            if(list.size()>0){
        %>
        
        <table border ="1px">
            <tr>
                <th>ID</th>
                <th>LOGO</th>
                <th>NAME</th>
                <th>ACTION</th>
            </tr>
            <%
                
                for(Club c: list){
                    String clubId = c.getClubId();
            %>
            <tr>
                <td><%= clubId %></td>
                <td><img src="<%= c.getClubLogo() %>" width="100px" height="100px"></td>
                <td><%= c.getClubName() %></td>
                <td>
                    <a href="#" onclick="doDeleteJoinedClub('<%= clubId %>','<%= studentId %>')"> MOVE</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <%
            }else{
        %>
        <h3>Student is not joining any club now!</h3>
        <%         
            }
        %>
    </body>
</html>
<%@ include file="/includes/column_left_home.jsp" %>
<%@ include file="/includes/footer.jsp" %>