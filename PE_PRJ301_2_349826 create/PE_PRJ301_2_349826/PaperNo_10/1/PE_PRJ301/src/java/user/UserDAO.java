/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.utils.DBUtils;

/**
 *
 * @author ASUS
 */
public class UserDAO {
       public UserDTO login(String UserID, String password){
        
        UserDTO user = null;
        try {

            try (Connection con = DBUtils.getConnection()) {            
                String sql = " SELECT userID, name FROM tblUser ";
                sql += " WHERE userID = ?  AND password = ?";
                               
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, UserID);
                stmt.setString(2, password);
                
                ResultSet rs = stmt.executeQuery();
                
                if (rs != null){
                    if (rs.next()){
                        
                        user = new UserDTO();                        
                        user.setUserID(rs.getString("userID"));
                        user.setName(rs.getString("name"));
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            } catch (SQLException ex) {                
                System.out.println("Error in servlet. Details:" + ex.getMessage());
                ex.printStackTrace();
                
            }
            return user;
        
    }
}
