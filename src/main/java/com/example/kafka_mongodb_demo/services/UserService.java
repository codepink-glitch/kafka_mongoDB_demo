package com.example.kafka_mongodb_demo.services;

import com.example.kafka_mongodb_demo.entities.UserEntity;
import com.example.kafka_mongodb_demo.kafka_producers.MyProducer;
import com.example.kafka_mongodb_demo.repositories.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository userEntityRepository;

    public UserEntity createNew(UserEntity userEntity) {
        UserEntity saved = userEntityRepository.save(userEntity);
        MyProducer.getQueue().offer(saved);
        return saved;
    }
}
