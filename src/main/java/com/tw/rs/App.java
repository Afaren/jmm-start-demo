/**
 * Created by afaren on 9/29/16.
 */
package com.tw.rs;

import com.tw.rs.mapper.UserMapper;
import com.tw.rs.util.DBUtil;
import org.apache.ibatis.session.SqlSessionManager;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("resources")
public class App extends ResourceConfig {

    public App() {
        SqlSessionManager session = DBUtil.getSession();
        final UserMapper userMapper = session.getMapper(UserMapper.class);


        packages("com.tw.rs.resource")
                .register(new AbstractBinder() {
                    @Override
                    protected void configure() {
                        bind(userMapper).to(UserMapper.class);
                    }
                });

    }
}