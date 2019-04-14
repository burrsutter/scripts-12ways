package org.acme.websocket;

import javax.enterprise.context.ApplicationScoped;

import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.Session;

// import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.jboss.logging.Logger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;


@ServerEndpoint("/wsendpoint")
@ApplicationScoped
public class WebSocket {

    private static final Logger LOG = Logger.getLogger(WebSocket.class);

    private int counter;
    private int sessioncounter;

    Map<String, Session> sessions = new ConcurrentHashMap<>();


    @OnOpen
    public void onOpen(Session session) {        
        sessioncounter++;
        LOG.info("onOpen: " + session.getId());        
        sessions.put(session.getId(),session); 
    }

    @OnClose
    public void onClose(Session session) {
        LOG.info("onClose: " + session.getId());
        sessions.remove(session.getId());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {        
        LOG.error("onError", throwable);        
    }

    @OnMessage
    public void onMessage(String message) {        
        LOG.info(counter++ + " " + message);
        broadcast();
    }

    private void broadcast() {
      sessions.keySet().forEach(key -> {
        Session s = sessions.get(key);
        s.getAsyncRemote().sendObject("tock", result ->  {
          if (result.getException() != null) {
            System.out.println("Unable to send message: " + result.getException());
          }
        });
      });
    }
}