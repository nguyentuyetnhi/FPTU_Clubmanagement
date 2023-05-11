<%-- 
    Document   : new_student
    Created on : Mar 1, 2023, 6:54:00 AM
    Author     : ACER NITRO 5
--%>
<%@ include file="/includes/header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student</title>
    </head>
    <body>
        <h1>Add Student</h1>
        <h3 style="color: red">${error}</h3>
        <form action="add-student">
            Enter ID: <input type="text" name="id"/><br/>
            Enter Name: <input type="text" name="name"/><br/>
            Enter Photo URL: <input type="text" name="photo"/><br/>
            <input type="submit" value="SAVE"/><br/>
        </form>
    </body>
</html>
<%@ include file="/includes/column_left_home.jsp" %>
<%@ include file="/includes/footer.jsp" %>