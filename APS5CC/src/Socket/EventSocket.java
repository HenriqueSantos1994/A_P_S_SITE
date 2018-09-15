package Socket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
 
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;

public class EventSocket extends WebSocketAdapter
{
	private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
	
	private String sourceAddress;
	
    @Override
    public void onWebSocketConnect(Session sess)
    {
        super.onWebSocketConnect(sess);
        System.out.println("Socket Connected: " + sess);
        
        sessions.add(sess);
        sourceAddress = sess.getRemoteAddress().getAddress().toString();
    }
    
    @Override
    public void onWebSocketText(String message)
    {
        super.onWebSocketText(message);
        sessions.forEach(session->
        {
        	String destinationAddress = session.getRemoteAddress().getAddress().toString();
        	
        	if (session.isOpen() && destinationAddress.equals(message))
        	{
        		try {
        			session.getRemote().sendString("Hello from /" + sourceAddress);	
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
        	}
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
