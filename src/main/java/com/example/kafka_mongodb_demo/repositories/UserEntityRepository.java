package com.example.kafka_mongodb_demo.repositories;

import com.example.kafka_mongodb_demo.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
}
