package org.acme.websocket;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.*;
// import javax.websocket.OnError;
// import javax.websocket.OnMessage;
// import javax.websocket.OnOpen;
// import javax.websocket.Session;
// import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.jboss.logging.Logger;

import io.smallrye.reactive.messaging.annotations.Stream;
import io.reactivex.Flowable;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.reactive.streams.operators.PublisherBuilder;

// import io.smallrye.reactive.messaging.

@ServerEndpoint("/")
@Health
@ApplicationScoped
public class WebSocket {

    private static final Logger LOG = Logger.getLogger(WebSocket.class);
    private int counter;

    // mystream configured in application.properties    
    @Inject @Stream("mystream") PublisherBuilder<String> stream;

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