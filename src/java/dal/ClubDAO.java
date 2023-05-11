/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import Model.Club;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author ACER NITRO 5
 */
public class ClubDAO  {
    // lay tat ca giu lieu tu bang club
    // SELECT * FROM club
    DBContext db= new DBContext();
    Connection con = db.getConnectionWithSqlJdbc();
    public List<Club> getAll( ){
        List<Club> list = new ArrayList<>();
        String sql ="SELECT * FROM club";
        
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Club c= new Club();
                c.setClubId(rs.getString("club_id"));
                c.setClubName(rs.getString("club_name"));
                c.setClubLogo(rs.getString("club_logo"));
                list.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        return list;
    }
    public void delete(String id){
        String sql= "DELETE FROM club WHERE club_id =?";
        try {
            PreparedStatement st= con.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public Club getClubById(String id){
        List<Club> list= getAll();
        for (Club club : list) {
            if(club.getClubId().equals(id)){
                return club;
            } 
        }
        return null;
    }
    
    public void add(Club club){
        String sql= "INSERT INTO club values(?,?,?)";
        try {
            PreparedStatement st= con.prepareCall(sql);
            st.setString(1, club.getClubId());
            st.setString(2, club.getClubLogo());
            st.setString(3, club.getClubName());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void update(Club club){
        String sql = "UPDATE club SET club_logo =?, club_name=? WHERE club_id=?";
        try {
            PreparedStatement st= con.prepareCall(sql);
            st.setString(1, club.getClubLogo());
            st.setString(2, club.getClubName());
            st.setString(3, club.getClubId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public List<Club> getClubsByListId(List<String> ids){
    List<Club> list= new ArrayList<>();
    String sqlRaw = "SELECT * FROM club WHERE club_id IN ";
    String endPart = "(";
        for (String id : ids) {
            endPart= endPart+"'"+id+"',";
        }
    String sqlMain = sqlRaw+endPart.substring(0, endPart.length()-1)+")";
        try {
            PreparedStatement ps= con.prepareStatement(sqlMain);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            Club c= new Club();
            c.setClubId(rs.getString("club_id"));
            c.setClubName(rs.getString("club_name"));
            c.setClubLogo(rs.getString("club_logo"));
            list.add(c);
        }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
