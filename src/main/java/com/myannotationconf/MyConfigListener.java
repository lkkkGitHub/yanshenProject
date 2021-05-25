package com.myannotationconf;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author lk
 * 2019/10/6 21:49
 */
public class MyConfigListener implements ServletContextListener {

    @Person("123123123")
    private String name;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        PersonHandler personHandler = new PersonHandler();
        try {
            personHandler.handPerson(this);
            System.out.println("myAnnotation = " + name);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
