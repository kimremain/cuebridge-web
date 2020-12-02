package com.jcuesoft.cuebridge.common.listener;

import java.lang.invoke.MethodHandles;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;


public class ShutdownCleanupListener implements ServletContextListener {
    
    final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }

    @SuppressWarnings("deprecation")
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
        /*The web application [ROOT] appears to have started a thread named [OracleTimeoutPollingThread] but has failed to stop it*/
        /*해결 못했으나 was shutdown시 오라클 gabage session 증가는 없으며 추후 재검토 요망*/        
        
        /*The web application [ROOT] registered the JDBC driver [oracle.jdbc.OracleDriver] but failed to unregister it when the web application was stopped*/        
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        Driver d = null;
        while(drivers.hasMoreElements()) {
            try {
                d = drivers.nextElement();
                DriverManager.deregisterDriver(d);
                logger.warn(String.format("Driver %s deregistered", d));
            } catch (SQLException ex) {
                logger.warn(String.format("Error deregistering driver %s", d), ex);
            }
        }
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
        for(Thread t:threadArray) {
            if(t.getName().contains("Abandoned connection cleanup thread")) {
                synchronized(t) {
                    t.stop(); //don't complain, it works
                }
            }
        }
        
        /*logback*/
        if (LoggerFactory.getILoggerFactory() instanceof LoggerContext) {
            ((LoggerContext) LoggerFactory.getILoggerFactory() ).stop();
        } 
    }
    
}