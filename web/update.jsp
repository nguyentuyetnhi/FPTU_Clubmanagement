<%-- 
    Document   : new
    Created on : Feb 27, 2023, 11:36:16 AM
    Author     : ACER NITRO 5
--%>
<%@ include file="/includes/header.jsp" %>
<%@page import="Model.Club"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Club</title>
    </head>
    <body>
        <h1>Update Club</h1>
        <%
            if(request.getAttribute("club")!=null){
            Club c= (Club)request.getAttribute("club");
        %>
        
        <form action="update-club" method="post">
            Enter ID: <input type="text" readonly name="id" value="<%= c.getClubId() %>"/><br/>
            Enter Logo url: <input type="text" name="logo" value="<%= c.getClubLogo()%>"/><br/>
            Enter Name: <input type="text" name="name" value="<%= c.getClubName()%>"/><br/>
            <input type="submit" value="UPDATE"/><br/>
        </form>
        <%
            }
        %>
    </body>
</html>
<%@ include file="/includes/column_left_home.jsp" %>
<%@ include file="/includes/footer.jsp" %>