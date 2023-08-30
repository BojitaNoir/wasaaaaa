package com.example.wasaaaaa.models;

import com.example.wasaaaaa.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

    public List<Class> findAllClasses() {
        List<Class> clases = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * from classes;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                Class class1 = new Class();
                class1.setClassId(rs.getLong("class_id"));
                class1.setClassName(rs.getString("class_name"));
                class1.setDescription(rs.getString("description"));
                class1.setInstructorId(rs.getLong("instructor_id"));
                class1.setStatus(rs.getString("status"));
                clases.add(class1);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error findAll"+e.getMessage());
        }finally {
            close();
        }
        return clases;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT u.user_id, u.email, u.password, u.status, u.role_id, " +
                    "p.first_name, p.last_name, p.curp, p.birthdate " +
                    "FROM users u " +
                    "INNER JOIN persons p ON u.person_id = p.person_id;";

            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setUserId(rs.getLong("user_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setCurp(rs.getString("curp"));
                user.setBirthdate(rs.getString("birthdate"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setStatus(rs.getString("status"));
                user.setRoleId(rs.getLong("role_id"));
                users.add(user);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error findAll"+e.getMessage());
        }finally {
            close();
        }
        return users;
    }

    public boolean saveI(User user) {
        try {
            conn = new MySQLConnection().connect();
            String query = "INSERT INTO persons (first_name, last_name, curp, birthdate) VALUES (?, ?, ?, ?)";
            pstm = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, user.getFirstName());
            pstm.setString(2, user.getLastName());
            pstm.setString(3, user.getCurp());
            pstm.setString(4, user.getBirthdate());
            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                return false;
            }

            ResultSet generatedKeys = pstm.getGeneratedKeys();
            if (generatedKeys.next()) {
                long personId = generatedKeys.getLong(1);
                query = "INSERT INTO users (person_id, email, password, status, role_id) VALUES (?, ?, ?, 'active', ?)";
                pstm = conn.prepareStatement(query);
                pstm.setLong(1, personId);
                pstm.setString(2, user.getEmail());
                pstm.setString(3, user.getPassword());
                pstm.setLong(4, user.getRoleId());
                return pstm.executeUpdate() > 0;
            } else {
                return false;
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error save: " + e.getMessage());
        } finally {
            close();
        }
        return false;
    }


    public List<User> findInstructors() {
        List<User> instructors = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT p.person_id, p.first_name FROM users u " +
                    "INNER JOIN persons p ON u.person_id = p.person_id " +
                    "WHERE u.role_id = 2;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                User instructor = new User();
                instructor.setPersonId(rs.getLong("person_id"));
                instructor.setFirstName(rs.getString("first_name"));
                instructors.add(instructor);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error findInstructors: " + e.getMessage());
        } finally {
            close();
        }
        return instructors;
    }

    public boolean saveC(String nombreClase, String descripcion, long instructorID) {
        try {
            conn = new MySQLConnection().connect();
            String query = "INSERT INTO classes (class_name, description, instructor_id, status) VALUES (?, ?, ?, 'Activo')";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, nombreClase);
            pstm.setString(2, descripcion);
            pstm.setLong(3, instructorID);
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error saveC: " + e.getMessage());
        } finally {
            close();
        }
        return false;
    }

    public List<Class> findAllClassesInstructor(Long userId) {
        List<Class> clases = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * from classes where instructor_id = "+userId+";";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                Class class1 = new Class();
                class1.setClassId(rs.getLong("class_id"));
                class1.setClassName(rs.getString("class_name"));
                class1.setDescription(rs.getString("description"));
                class1.setInstructorId(rs.getLong("instructor_id"));
                class1.setStatus(rs.getString("status"));
                clases.add(class1);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error findAll"+e.getMessage());
        }finally {
            close();
        }
        return clases;
    }

    public List<User> findUserClass(Long id) {
        List<User> users = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT p.first_name FROM persons p " +
                    "INNER JOIN users u ON p.person_id = u.person_id " +
                    "INNER JOIN enrollments ce ON u.user_id = ce.user_id WHERE ce.class_id = ?;";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString("first_name"));
                users.add(user);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error findUserClass: " + e.getMessage());
        } finally {
            close();
        }
        return users;
    }
}
