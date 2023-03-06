package com.naga;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaConsumerModuleMain {
    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerModuleMain.class);
        System.out.println("Hello world!");
    }
}
