package org.acme.kafkaconsumer;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;
import java.util.concurrent.CompletionStage;

import io.smallrye.reactive.messaging.kafka.KafkaMessage;

@ApplicationScoped
public class MyStreamSubscriber {
    private static final Logger LOG = Logger.getLogger(MyStreamSubscriber.class);

/* 
    @Incoming("mystream")
    public void process(String msg) {
        LOG.info(msg);
    }     
*/

    @Incoming("mystream")
    public CompletionStage<Void> process(KafkaMessage<String,String> msg) {
        LOG.info(msg.getPayload());
        return msg.ack();
    }
}