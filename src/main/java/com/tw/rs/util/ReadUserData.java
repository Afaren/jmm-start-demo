package com.tw.rs.util;

import com.mysql.jdbc.Connection;
import com.tw.rs.bean.User;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by afaren on 10/3/16.
 */
public class ReadUserData {
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/jmmStartDemo";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql"; // todo 修改为你自己的 mysql root 密码
    private static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM jmmStartDemo.users WHERE id = ";


    public ReadUserData() {
    }

    public User getUserById(int id) throws SQLException, ClassNotFoundException {

        User user = null;
        Connection c = null;
        try {
            Class.forName(DRIVER_CLASS);
            c = (Connection) DriverManager.getConnection(DB_URL, USER, PASSWORD);
            ResultSet rs = c.createStatement().executeQuery(SQL_SELECT_USER_BY_ID + id);

            if (rs.next()) {
                user = new User();
                user.setName(rs.getString("name"));
                user.setGender(rs.getString("gender"));
                user.setId(rs.getInt("id"));
            }

        } finally {
            c.close();
        }


        return user;
    }
}
