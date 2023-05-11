/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ACER NITRO 5
 */
public class Club {
    private String clubId;
    private String clubName;
    private String clubLogo;

    public Club(String clubId, String clubName, String clubLogo) {
        this.clubId = clubId;
        this.clubName = clubName;
        this.clubLogo= clubLogo;
    }

    public Club() {
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public String getClubLogo() {
        return clubLogo;
    }

    public void setClubLogo(String clubLogo) {
        this.clubLogo = clubLogo;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
    
      
}
