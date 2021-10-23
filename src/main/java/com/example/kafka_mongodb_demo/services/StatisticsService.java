package com.example.kafka_mongodb_demo.services;

import com.example.kafka_mongodb_demo.entities.Statistics;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final MongoTemplate mongoTemplate;

    public List<Statistics> getAll(){
        return mongoTemplate.findAll(Statistics.class);
    }
}
