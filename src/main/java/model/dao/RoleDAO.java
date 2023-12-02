package model.dao;

import model.bean.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoleDAO extends BaseDAO {

    public ArrayList<Role> GetList(){
        ArrayList<Role> list = new ArrayList<>();

        String sql = "select * from role";
        ResultSet rs = null;

        try {
            rs = stm.executeQuery(sql);
            while (rs.next()){
                list.add(new Role(rs.getString(1),rs.getString(2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  list;
    }

}
