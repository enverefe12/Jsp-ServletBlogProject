package com.Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Bu Listener sınıfın amacı kaç session aktif olduğuna bakmak amaçlıdır.
 * --- Düzgün Çalışmıyor 
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

	public static int activeSessions=0;
	
    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("Session Çalıştırıldı. ID:" + se.getSession().getId());
    	   synchronized (this) {
    		   activeSessions++;
    		  }
    	   System.out.println(activeSessions);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println(se.getSession().getId() + " ID li session kapatıldı.");
    	if(activeSessions>0) {
    		   synchronized (this) {
        		   activeSessions--;
        		  }
        	   System.out.println(activeSessions);
    	}
    	
    }


    
    
	
}
