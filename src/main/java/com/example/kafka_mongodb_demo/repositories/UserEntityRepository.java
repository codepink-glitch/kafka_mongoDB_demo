package com.example.kafka_mongodb_demo.repositories;

import com.example.kafka_mongodb_demo.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends MongoRepository<UserEntity, Long> {
}
