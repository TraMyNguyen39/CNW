package model.bo;

import model.bean.User;
import model.dao.UserDAO;

import java.util.ArrayList;

public class UserBO {
    private UserDAO dao;
    public UserBO(){
        dao = new UserDAO();
    }
    public ArrayList<User> GetList(){
        return dao.GetList();
    }
    public void Insert(User user) {
        dao.Insert(user);
    }
    public void Update(User user) {
        dao.Update(user);
    }
    public void Delete(String userId) {
        dao.Delete(userId);
    }

    public User CheckLogin(String username, String password){
        return dao.CheckLogin(username,password);
    }
    public User GetUser(String username){
        return dao.GetUser(username);
    }
    public ArrayList<User> Filter(String value){
        return dao.Filter(value);
    }
}
