/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package house;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

/**
 *
 * @author ASUS
 */
public class HouseDAO {
        public List<HouseDTO> list(String keyword) throws ClassNotFoundException {
        List<HouseDTO> list = new ArrayList<>();
        String sql = "SELECT id, name,description, size,status FROM tblHouse";
        
        if (keyword != null && !keyword.isEmpty()) {
            sql += " WHERE name LIKE ?";
        }

        try (Connection con = DBUtils.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            if (keyword != null && !keyword.isEmpty()) {
                stmt.setString(1, "%" + keyword + "%");
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HouseDTO hs = new HouseDTO();
             
                hs.setId(rs.getString("id"));           
                hs.setName(rs.getString("name"));
                hs.setDescription(rs.getString("description"));
                hs.setSize(rs.getFloat("size"));
                hs.setStatus(rs.getBoolean("status"));
                list.add(hs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
        
            public boolean delete(String id) throws ClassNotFoundException {
        String sql = "UPDATE tblHouse status = 0 WHERE id = ?";
        
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
        
        
}
