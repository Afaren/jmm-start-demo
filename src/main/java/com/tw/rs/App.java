/**
 * Created by afaren on 9/29/16.
 */
package com.tw.rs;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("resources")
public class App  extends ResourceConfig {

    public App() {
        packages("com.tw.rs").register(new AbstractBinder() {
            @Override
            protected void configure() {

            }
        });

    }
}