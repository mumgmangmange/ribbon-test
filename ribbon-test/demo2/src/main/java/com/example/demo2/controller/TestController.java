package com.example.demo2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/test/{id}")
    public String getId(@PathVariable("id") Long id) {
        log.info(">>>>>>demo2 getId method<<<<<<<");
        return id.toString();
    }
}