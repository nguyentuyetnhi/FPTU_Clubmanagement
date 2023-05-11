<%-- 
    Document   : new
    Created on : Feb 27, 2023, 11:36:16 AM
    Author     : ACER NITRO 5
--%>
<%@ include file="/includes/header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Club</title>
    </head>
    <body>
        <h1>Add Club</h1>
        <h3 style="color: red">${error}</h3>
        <form action="add">
            Enter ID: <input type="text" name="id"/><br/>
            Enter Logo url: <input type="text" name="logo"/><br/>
            Enter Name: <input type="text" name="name"/><br/>
            <input type="submit" value="SAVE"/><br/>
        </form>
    </body>
</html>
<%@ include file="/includes/column_left_home.jsp" %>
<%@ include file="/includes/footer.jsp" %>