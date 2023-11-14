/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Role;
import model.User;

/**
 *
 * @author aablia
 */
public class EmployeeDao {

    private Connection establishConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/employee",
                    "postgres", "Aa1122");
            //  System.out.println("Connection established."); 
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int insert(User user) {

        Connection conn = establishConnection();
        try {
            String sql = "INSERT INTO users(email, role, password, name, age, skill, postion, address) VALUES(?,?,?,?,?,?,?,?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getRole().name());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getName());
            statement.setInt(5, user.getAge());
            statement.setString(6, user.getSkill());
            statement.setString(7, user.getPostion());
            statement.setString(8, user.getAddress());

            int num = statement.executeUpdate();
            statement.close();
            return num;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    public User find(String email) {
        Connection conn = establishConnection();
        try {
            String sql = "SELECT * FROM users WHERE email=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();
            User user = null;

            if (result.next()) {
                user = new User();
                user.setId(result.getLong("id"));
                user.setEmail(result.getString("email"));
                user.setRole(Role.valueOf(result.getString("role")));
                user.setName(result.getString("name"));
                user.setAge(result.getInt("age"));
                user.setSkill(result.getString("skill"));
                user.setAddress(result.getString("address"));
                user.setPassword(result.getString("password"));

                statement.close();
                result.close();
                return user;
            }
            return user;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }

    public List<User> findAll() {
        List<User> employees = new ArrayList<>();
        Connection conn = establishConnection();
        try {
            String sql = "SELECT * FROM users";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            User user = null;

            while (result.next()) {

                user = new User();
                user.setId(result.getLong("id"));
                user.setEmail(result.getString("email"));
                user.setName(result.getString("name"));
                user.setAge(result.getInt("age"));
                user.setSkill(result.getString("skill"));
                user.setAddress(result.getString("address"));
                user.setPostion(result.getString("postion"));

                employees.add(user);
            }
            statement.close();
            result.close();
            return employees;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }

    public int update(User user) {

        Connection conn = establishConnection();
        try {

            String sql = "UPDATE users SET email= ?, role= ?,password= ?, name= ?, age= ?, skill= ?, postion= ?, address= ? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getRole().name());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getName());
            statement.setInt(5, user.getAge());
            statement.setString(6, user.getSkill());
            statement.setString(7, user.getPostion());
            statement.setString(8, user.getAddress());
            statement.setLong(9, user.getId());
            int num = statement.executeUpdate();

            statement.close();
            return num;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;

    }

    public User findById(Long id) {
        Connection conn = establishConnection();
        User user = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            String sql = "SELECT * FROM users WHERE id=?";
            statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            result = statement.executeQuery();
            if (result.next()) {
                user = new User();
                user.setId(result.getLong("id"));
                user.setEmail(result.getString("email"));
                user.setRole(Role.valueOf(result.getString("role")));
                user.setName(result.getString("name"));
                user.setAge(result.getInt("age"));
                user.setSkill(result.getString("skill"));
                user.setAddress(result.getString("address"));
                user.setPassword(result.getString("password"));
                user.setPostion(result.getString("postion"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                result.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }

    public int delete(Long id) {

        Connection conn = establishConnection();
        try {

            String sql = "DELETE FROM users WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            int num = statement.executeUpdate();
            statement.close();
            return num;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;

    }
}
