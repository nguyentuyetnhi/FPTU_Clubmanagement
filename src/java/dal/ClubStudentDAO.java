/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

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
public class ClubStudentDAO {
    DBContext db= new DBContext();
    Connection con = db.getConnectionWithSqlJdbc();
    public List<String> getListOfJoinedClubId(String studentId){
        List<String> list = new ArrayList<>();
        String sql ="SELECT club_id FROM student_club WHERE student_id =?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, studentId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                list.add(rs.getString("club_id"));
            }
        } catch (SQLException e) {
        }
        return list;
    }
    public List<String> getListOfJoinedStudentId(String clubId){
        List<String> list = new ArrayList<>();
        String sql ="SELECT student_id FROM student_club WHERE club_id =?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, clubId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                list.add(rs.getString("student_id"));
            }
        } catch (SQLException e) {
        }
        return list;
    }
    public boolean isJoining(String studentId, String clubId){
        String sql = "SELECT * FROM student_club WHERE student_id=? AND club_id = ?";
        List<String> studentList = new ArrayList<>();
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, studentId);
            ps.setString(2, clubId);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                studentList.add(rs.getString("student_id"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
              
        return !studentList.isEmpty();
    }
    public void delete(String clubId, String studentId){
        String sql= "DELETE FROM student_club WHERE club_id =? AND student_id=?";
        try {
            PreparedStatement st= con.prepareStatement(sql);
            st.setString(1, clubId);
            st.setString(2, studentId);          
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void add(String clubId, String studentId){
        String sql= "INSERT INTO student_club values(?,?)";
        try {
            PreparedStatement st= con.prepareCall(sql);
            st.setString(1, studentId);
            st.setString(2, clubId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
