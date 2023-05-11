<%-- 
    Document   : list-student
    Created on : Mar 1, 2023, 6:49:38 AM
    Author     : ACER NITRO 5
--%>
<%@ include file="/includes/header.jsp" %>
<%@page import="java.util.List"%>
<%@page import="Model.Club"%>
<%@page import="Model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student</title>
        <style>
            table{
                border-collapse: collapse;
            }
            td{
                padding: 10px;
            }
        </style>
        <script type="text/javascript">
            function doDeleteStudent(id){
                if(confirm("Are you sure to delete the student with id ="+id+"?")){
                    window.location="delete-student?id="+id;
                }
            }
        </script>
    </head>
    <body>
        <h1>List of Student</h1>
        <h3><a href="new_student.jsp"> Add New Student</a></h3>
        <table border ="1px">
            <tr>
                <th>ID</th>
                <th>Photo</th>
                <th>NAME</th>
                <th>ACTION</th>
            </tr>
            <%
                List<Student> list=(List<Student>) request.getAttribute("data");
                for(Student s: list){
                    String id = s.getStudentId();
            %>
            <tr>
                <td><%= id %></td>
                <td><img src="<%= s.getPhotoUrl()%>" width="100px" height="100px"></td>
                <td><%= s.getStudentName()%></td>
                <td>
                    <a href="joined-club?id=<%= id %>">View List Club</a>&nbsp;&nbsp;&nbsp;
                    <a href="update-student?id=<%= id %>">Update</a>&nbsp;&nbsp;&nbsp;
                    
                    <a href="#" onclick="doDeleteStudent('<%= id %>')"> Delete</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
<%--<%@ include file="/includes/column_left_home.jsp" %>--%>
<%@ include file="/includes/footer.jsp" %>