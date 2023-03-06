package com.naga.kafkaProducer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import com.naga.config.MediaChangeshandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class MediaChangesProducer {

    private static final Logger LOGGER= LoggerFactory.getLogger(MediaChangesProducer.class);

    private KafkaTemplate<String,String> kafkaTemplate;

    public MediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishChanges() throws InterruptedException {
        String topic ="wikiMediaChanges";
        //Read wiki media stream events we create event source
        EventHandler eventHandler =new MediaChangeshandler(kafkaTemplate,topic);
        String url ="https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(10);
    }
}
