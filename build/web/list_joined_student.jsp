<%-- 
    Document   : list_joined_student
    Created on : Mar 1, 2023, 8:25:47 AM
    Author     : ACER NITRO 5
--%>
<%@ include file="/includes/header.jsp" %>
<%@page import="Model.Student"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Joined Student</title>
        <style>
            table{
                border-collapse: collapse;
            }
            td{
                padding: 10px;
            }
        </style>
        <script type="text/javascript">
            function doDeleteJoinedStudent(clubId, studentId){
                if(confirm("Are you sure to kick the the student with id ="+studentId+"?")){
                    window.location="delete-joined-student?club-id="+clubId+"&student-id="+studentId;
                }
            }
        </script>
    </head>
    <body>
        <%
            List<Student> list=(List<Student>) request.getAttribute("data");
            String clubId = (String) request.getAttribute("clubId");

        %>
        <h1>List of student in club</h1>
        <h3><a href="add_student.jsp?clubId=<%= clubId %>"> Add New Student</a></h3>
        <% 
        if(list.size()>0){
        %>
        
        <table border ="1px">
            <tr>
                <th>ID</th>
                <th>PHOTO</th>
                <th>NAME</th>
                <th>ACTION</th>
            </tr>
            <%
                
                for(Student s: list){
                    String studentId = s.getStudentId();
            %>
            <tr>
                <td><%= studentId %></td>
                <td><img src="<%= s.getPhotoUrl()%>" width="100px" height="100px"></td>
                <td><%= s.getStudentName()%></td>
                <td>
                    <a href="#" onclick="doDeleteJoinedStudent('<%= clubId %>','<%= studentId %>')"> KICK</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <%
            }else{
        %>
        <h3>There is no student join club now!</h3>
        <%         
            }
        %>
    </body>
</html>
<%@ include file="/includes/column_left_home.jsp" %>
<%@ include file="/includes/footer.jsp" %>