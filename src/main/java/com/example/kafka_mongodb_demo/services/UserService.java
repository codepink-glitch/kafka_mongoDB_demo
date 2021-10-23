package com.example.kafka_mongodb_demo.services;

import com.example.kafka_mongodb_demo.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final MongoTemplate mongoTemplate;

    public UserEntity createNew(UserEntity userEntity) {
        return mongoTemplate.save(userEntity);
    }
}
