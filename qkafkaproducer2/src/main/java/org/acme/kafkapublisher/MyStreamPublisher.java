package org.acme.kafkapublisher;

import javax.enterprise.context.ApplicationScoped;

import org.jboss.logging.Logger;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;

import javax.enterprise.event.Observes;
import io.quarkus.runtime.StartupEvent;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class MyStreamPublisher {
    private static final Logger LOG = Logger.getLogger(MyStreamPublisher.class);
    
    KafkaProducer producer = null; 

    @ConfigProperty(name = "topic")
    String topic;

    @ConfigProperty(name = "bootstrap.servers")
    String bootstrapservers;

    @ConfigProperty(name = "key.serializer")
    String keyserializer;

    @ConfigProperty(name = "value.serializer")
    String valueserializer;

    @ConfigProperty(name = "group.id")
    String groupid;

    void onStart(@Observes StartupEvent ev) {
        LOG.info("onStart");
        Properties props = new Properties();
        props.setProperty("topic", topic);
        props.setProperty("bootstrap.servers", bootstrapservers);
        props.setProperty("key.serializer", keyserializer);
        props.setProperty("value.serializer", valueserializer);
        props.setProperty("group.id", groupid);
        producer = new KafkaProducer(props);
        for (int i = 0; i < 20; i++) {
            producer.send(new ProducerRecord(topic,  "Hello - " + i));
        }
    }

}