package org.acme.kafkaconsumer;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;
import org.eclipse.microprofile.health.Health;

@Health
@ApplicationScoped
public class MyStreamSubscriber {
    private static final Logger LOG = Logger.getLogger(MyStreamSubscriber.class);

    @Incoming("mystream")
    public void process(String msg) {
        LOG.info(msg);
    }    
}