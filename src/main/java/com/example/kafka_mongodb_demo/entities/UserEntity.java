package com.example.kafka_mongodb_demo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "user")
public class UserEntity {

    @Id
    private String id;

    private String username;

    private String name;
}
