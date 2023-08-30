package com.example.wasaaaaa.models;

import com.example.wasaaaaa.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUser {
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;

    public User loginUser(String email, String password) {
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT u.user_id, p.first_name, p.last_name, p.curp, p.birthdate, " +
                    "u.email, u.status, u.role_id  " +
                    "FROM users u " +
                    "JOIN persons p ON u.person_id = p.person_id " +
                    "JOIN roles r ON u.role_id = r.role_id " +
                    "WHERE u.email = ? AND u.password = ? AND u.status = 'active';";

            pstm = conn.prepareStatement(query);
            pstm.setString(1, email);
            pstm.setString(2,password);
            rs = pstm.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getLong("user_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setCurp(rs.getString("curp"));
                user.setBirthdate(rs.getString("birthdate"));
                user.setEmail(rs.getString("email"));
                user.setStatus(rs.getString("status"));
                user.setRoleId(rs.getLong("role_id"));
                return user;
            }

        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE,
                            "Credentials mismatch: " + e.getMessage());
        } finally {
            close();
        }
        return null;
    }

    public void close(){
        try {
            if(conn != null) conn.close();
            if (pstm != null) pstm.close();
            if (rs != null) rs.close();
        }catch (SQLException e){

        }

    }
}
