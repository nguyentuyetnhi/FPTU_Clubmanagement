<%-- 
    Document   : update_student
    Created on : Mar 1, 2023, 7:04:18 AM
    Author     : ACER NITRO 5
--%>
<%@ include file="/includes/header.jsp" %>
<%@page import="Model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Student</title>
    </head>
    <body>
        <h1>Update Student</h1>
        <%
            if(request.getAttribute("student")!=null){
            Student s= (Student)request.getAttribute("student");
        %>
        
        <form action="update-student" method="post">
            Enter ID: <input type="text" readonly name="id" value="<%= s.getStudentId()%>"/><br/>
            Enter Photo URL: <input type="text" name="photo" value="<%= s.getPhotoUrl()%>"/><br/>
            Enter Name: <input type="text" name="name" value="<%= s.getStudentName()%>"/><br/>
            <input type="submit" value="UPDATE"/><br/>
        </form>
        <%
            }
        %>
    </body>
</html>
<%@ include file="/includes/column_left_home.jsp" %>
<!--<%@ include file="/includes/footer.jsp" %>-->