package com.example.demo.service.impl;

import com.example.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Override
    public String sayHello(String name) {
        log.info("service request {}", name);
        return "hello " + name;
    }
}
