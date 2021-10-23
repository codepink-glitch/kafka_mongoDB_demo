package com.example.kafka_mongodb_demo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "statistics")
public class Statistics {

    @Id
    private String id;

    private String name;

    private int numberOfMentions;
}
