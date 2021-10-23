package com.example.kafka_mongodb_demo.rest_controllers;

import com.example.kafka_mongodb_demo.entities.Statistics;
import com.example.kafka_mongodb_demo.entities.UserEntity;
import com.example.kafka_mongodb_demo.services.StatisticsService;
import com.example.kafka_mongodb_demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final StatisticsService statisticsService;

    @PostMapping("/new")
    public ResponseEntity<UserEntity> createNew(@RequestBody UserEntity userEntity) {
        return new ResponseEntity<>(userService.createNew(userEntity), HttpStatus.OK);
    }

    @GetMapping("/statistics")
    public ResponseEntity<List<Statistics>> getStatistics() {
        return new ResponseEntity<>(statisticsService.getAll(), HttpStatus.OK);
    }
}
