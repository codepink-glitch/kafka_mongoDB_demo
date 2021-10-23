package com.example.kafka_mongodb_demo.repositories;

import com.example.kafka_mongodb_demo.entities.Statistics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends MongoRepository<Statistics, String> {
}
