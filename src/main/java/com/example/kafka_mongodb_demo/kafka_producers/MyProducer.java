package com.example.kafka_mongodb_demo.kafka_producers;

import com.example.kafka_mongodb_demo.entities.UserEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
@RequiredArgsConstructor
@Slf4j
public class MyProducer {


    private static final String TOPIC = "test-topic";
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Getter
    private static final Queue<UserEntity> queue = new ConcurrentLinkedQueue<>();

    @Scheduled(fixedRate = 100)
    public void produce() throws UnknownHostException {
        if(!queue.isEmpty()) {
            String userName = queue.poll().getName();
            kafkaTemplate.send(TOPIC, userName);
            log.info("send username: " + userName + " to kafka.");
        }
    }


}
