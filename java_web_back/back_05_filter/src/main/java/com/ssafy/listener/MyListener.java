package com.ssafy.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
@WebListener
public class MyListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyListener() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	System.out.println("웹어플리케이션 시작할때 호출");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	System.out.println("웹어플리케이션 종료할때 호출");
    	
    }
	
}
