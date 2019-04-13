package org.acme.websocket;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.*;
// import javax.websocket.OnError;
// import javax.websocket.OnMessage;
// import javax.websocket.OnOpen;
// import javax.websocket.Session;
// import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.jboss.logging.Logger;
// import org.eclipse.microprofile.health.Health;

@ServerEndpoint("/shake")
@ApplicationScoped
public class WebSocket {

    private static final Logger LOG = Logger.getLogger(WebSocket.class);

    private int counter;

    @OnOpen
    public void onOpen(Session session) {
        LOG.info("onOpen");
    }

    @OnClose
    public void onClose(Session session) {
        LOG.info("onClose");
    }

    @OnError
    public void onError(Session session, Throwable throwable) {        
        LOG.error("onError", throwable);        
    }

    @OnMessage
    public void onMessage(String message) {
        
        LOG.info(counter++ + " " + message);
    }

}