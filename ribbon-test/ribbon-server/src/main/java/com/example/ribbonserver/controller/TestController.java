package com.example.ribbonserver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

    final RestTemplate template;

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, HttpServletRequest request) {

        String result = template.getForObject("http://demo1/test/{id}", String.class, id);
        log.info("[1] 호출을 하였어요!>>>> result:{}, id:{}, localPort:{}", result, id, request.getLocalPort());

        String result2 = template.getForObject("http://demo2/test/{id}", String.class, id);
        log.info("[2] 호출을 하였어요!>>>> result2:{}, id:{}, localPort:{}", result2, id, request.getLocalPort());
        return "true";
    }
}
