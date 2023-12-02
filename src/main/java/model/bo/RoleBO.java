package model.bo;

import model.bean.Role;
import model.dao.RoleDAO;

import java.util.ArrayList;

public class RoleBO {
    private RoleDAO dao;
    public  RoleBO(){
        dao = new RoleDAO();
    }
    public ArrayList<Role> GetList(){
        return dao.GetList();
    }
}
