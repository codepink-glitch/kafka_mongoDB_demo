package com.example.kafka_mongodb_demo.entities;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "user_entity")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_entity_id")
    private Long id;

    @Column(name = "user_entity_username", nullable = false)
    private String username;

    @Column(name = "user_entity_name", nullable = false)
    private String name;
}
