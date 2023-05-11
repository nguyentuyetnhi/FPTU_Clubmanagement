/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER NITRO 5
 */
public class StudentDAO {
    DBContext db= new DBContext();
    Connection con = db.getConnectionWithSqlJdbc();
    public List<Student> getAll( ){
        List<Student> list = new ArrayList<>();
        String sql ="SELECT * FROM student";
        
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Student c= new Student();
                c.setStudentId(rs.getString("student_id"));
                c.setStudentName(rs.getString("student_name"));
                c.setPhotoUrl(rs.getString("student_photo_url"));
                list.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        return list;
    }
    public void delete(String id){
        String sql= "DELETE FROM student WHERE student_id =?";
        try {
            PreparedStatement st= con.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public Student getStudentById(String id){
        List<Student> list= getAll();
        for (Student student : list) {
            if(student.getStudentId().equals(id)){
                return student;
            } 
        }
        return null;
    }
    
    public void add(Student student){
        String sql= "INSERT INTO student values(?,?,?)";
        try {
            PreparedStatement st= con.prepareCall(sql);
            st.setString(1, student.getStudentId());
            st.setString(2, student.getStudentName());
            st.setString(3, student.getPhotoUrl());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void update(Student student){
        String sql = "UPDATE student SET student_photo_url =?, student_name=? WHERE student_id=?";
        try {
            PreparedStatement st= con.prepareCall(sql);
            st.setString(1, student.getPhotoUrl());
            st.setString(2, student.getStudentName());
            st.setString(3, student.getStudentId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public List<Student> getStudentsByListId(List<String> ids){
    List<Student> list= new ArrayList<>();
    String sqlRaw = "SELECT * FROM student WHERE student_id IN ";
    String endPart = "(";
        for (String id : ids) {
            endPart= endPart+"'"+id+"',";
        }
    String sqlMain = sqlRaw+endPart.substring(0, endPart.length()-1)+")";
        try {
            PreparedStatement ps= con.prepareStatement(sqlMain);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            Student s= new Student();
            s.setStudentId(rs.getString("student_id"));
            s.setStudentName(rs.getString("student_name"));
            s.setPhotoUrl(rs.getString("student_photo_url"));
            list.add(s);
        }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
