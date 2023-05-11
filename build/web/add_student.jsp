<%-- 
    Document   : add_student
    Created on : Mar 1, 2023, 8:37:32 AM
    Author     : ACER NITRO 5
--%>
<%@ include file="/includes/header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add student </title>
    </head>
    <body>
        <h1>Add student to club</h1>
        <h3 style="color: red">${error}</h3>
        <form action="add-into-club">
            Club ID: <input type="text" name="club-id" readonly value="<%= request.getParameter("clubId") %>"/><br/>
            Enter Student ID: <input type="text" name="student-id"/><br/>
            <input type="submit" value="ADD"/><br/>
        </form>
    </body>
</html>
<%@ include file="/includes/column_left_home.jsp" %>
<%@ include file="/includes/footer.jsp" %>