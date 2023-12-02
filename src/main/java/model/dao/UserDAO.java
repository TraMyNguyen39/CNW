package model.dao;

import model.bean.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO extends BaseDAO {

    public ArrayList<User> GetList(){
        ArrayList<User> list = new ArrayList<>();

        String sql = "select * from User";
        ResultSet rs = null;

        try {
            rs = stm.executeQuery(sql);
            while (rs.next()){
                list.add(new User(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  list;
    }
    public void Insert(User user) {
        String sql = "INSERT INTO User (firstname, lastname, username, password, idrole) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = cnn.prepareStatement(sql);
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getUserName());
            stmt.setString(4, user.getPassWord());
            stmt.setString(5, user.getIdRole());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void Update(User user) {
        String sql = "UPDATE User SET firstname = ?, lastname = ?, password = ?, idrole = ? WHERE username = ?";

        try {
            PreparedStatement stmt = cnn.prepareStatement(sql);
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getPassWord());
            stmt.setString(4, user.getIdRole());
            stmt.setString(5, user.getUserName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void Delete(String userId) {
        String sql = "DELETE FROM User WHERE username = ?";

        try {
            PreparedStatement stmt = cnn.prepareStatement(sql);
            stmt.setString(1, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public User CheckLogin(String username, String password){
        String sql = "select * from User where username = ? and password = ? ";
        User user = null;
        try {
            PreparedStatement stmt = cnn.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2,password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                user = new User(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public User GetUser(String username){
        String sql = "select * from User where username = ?";
        User user = null;
        try {
            PreparedStatement stmt = cnn.prepareStatement(sql);
            stmt.setString(1,username);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                user = new User(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<User> Filter(String value){
        ArrayList<User> list = new ArrayList<>();

        String sql = "select * from User where firstname like '%"+value+"%' or lastname like '%"+ value +"%' ";
        System.out.println(sql);
        ResultSet rs = null;

        try {
            rs = stm.executeQuery(sql);
            while (rs.next()){
                list.add(new User(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
