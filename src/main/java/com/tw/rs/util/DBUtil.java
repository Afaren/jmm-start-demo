package com.tw.rs.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by afaren on 10/3/16.
 */
public class DBUtil {
    private DBUtil() {}

    public static SqlSessionManager getSession() {
        String resource = "mybatis/mybatis-config.xml";
        SqlSessionManager session = null;

        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(is);
            session = SqlSessionManager.newInstance(sqlSessionFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return session;
    }
}
