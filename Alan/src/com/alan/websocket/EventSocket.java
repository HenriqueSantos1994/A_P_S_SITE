package com.alan.websocket;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;

public class EventSocket extends WebSocketAdapter
{
	
	private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
	private Session sess;
	
    @Override
    public void onWebSocketConnect(Session sess)
    {
        super.onWebSocketConnect(sess);
        System.out.println("Socket Connected: " + sess);
        sessions.add(sess);
        this.sess = sess;
    }
    
    @Override
    public void onWebSocketText(String message)
    {
        super.onWebSocketText(message);
        
        sessions.forEach(session->{
        	
        	InetAddress sentAddress = sess.getRemoteAddress().getAddress();
        	InetAddress receiveAddress = session.getRemoteAddress().getAddress();
        	
//    		if(session.isOpen() && !sentAddress.equals(receiveAddress)){
    		try {
    			session.getRemote().sendString(sentAddress + ": " + message);
					
			} catch (IOException e) {
					e.printStackTrace();
			}
//    		}
    	});
    }
    
    
    @Override
    public void onWebSocketClose(int statusCode, String reason)
    {
        super.onWebSocketClose(statusCode,reason);
        System.out.println("Socket Closed: [" + statusCode + "] " + reason);
    }
    
    @Override
    public void onWebSocketError(Throwable cause)
    {
        super.onWebSocketError(cause);
        cause.printStackTrace(System.err);
    }
}
