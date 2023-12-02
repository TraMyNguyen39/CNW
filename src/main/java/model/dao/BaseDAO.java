package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO {
    protected Connection cnn;
    protected Statement stm;
    public BaseDAO(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            stm = cnn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
