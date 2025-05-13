/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author ASUS
 */
public class UserDTO {
    private String UserID ;
    private String name ;
    private String password ;

    public UserDTO() {
    }

    public UserDTO(String UserID, String name, String password) {
        this.UserID = UserID;
        this.name = name;
        this.password = password;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "UserID=" + UserID + ", name=" + name + ", password=" + password + '}';
    }
    
}
