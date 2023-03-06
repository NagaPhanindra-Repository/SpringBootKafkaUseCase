package com.naga;

import com.naga.entity.MediaData;
import com.naga.repository.MediDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    private MediDataRepository mediDataRepository;

    public KafkaConsumer(MediDataRepository mediDataRepository) {
        this.mediDataRepository = mediDataRepository;
    }

    @KafkaListener(topics = "wikiMediaChanges",groupId = "myGroup")
    public void consume(String eventMessage){
        LOGGER.info(String.format("Event Message received %s",eventMessage));

        MediaData mediaData =new MediaData();
        mediaData.setEventData(eventMessage);
        mediDataRepository.save(mediaData);
    }
}
