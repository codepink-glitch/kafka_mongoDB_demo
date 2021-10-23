package com.example.kafka_mongodb_demo.kafka_consumers;

import com.example.kafka_mongodb_demo.entities.Statistics;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class MyConsumer {

    private final MongoTemplate mongoTemplate;

    @KafkaListener(topics = "test-topic")
    public void consume(String message) throws UnknownHostException {
        log.info("Recieved kafka message: " + message);
        Query query = new Query().addCriteria(Criteria.where("name").is(message))
                .addCriteria(Criteria.where("numberOfMentions").exists(true));

        List<Statistics> statisticsList = mongoTemplate.find(query, Statistics.class);

        if(statisticsList.isEmpty()){
            Statistics statistics = new Statistics();
            statistics.setName(message);
            statistics.setNumberOfMentions(1);
            mongoTemplate.save(statistics);
        } else {
            Statistics statistics = statisticsList.get(0);
            statistics.setNumberOfMentions(statistics.getNumberOfMentions() + 1);
            mongoTemplate.save(statistics);
        }

    }
}
