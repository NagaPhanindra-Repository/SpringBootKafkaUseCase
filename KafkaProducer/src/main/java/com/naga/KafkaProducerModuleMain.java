package com.naga;

import com.naga.kafkaProducer.MediaChangesProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerModuleMain implements CommandLineRunner {
    @Autowired
    private MediaChangesProducer mediaChangesProducer;
    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerModuleMain.class);
        System.out.println("Hello world!");
    }

    @Override
    public void run(String... args) throws Exception {
        mediaChangesProducer.publishChanges();
    }
}
