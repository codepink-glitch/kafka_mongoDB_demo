package com.example.kafka_mongodb_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaMongoDbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaMongoDbDemoApplication.class, args);
    }

}
