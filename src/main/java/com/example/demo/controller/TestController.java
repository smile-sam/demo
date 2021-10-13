package com.example.demo.controller;

import com.example.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.apache.skywalking.apm.toolkit.trace.TraceCrossThread;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class TestController {

    @Resource
    private TestService testService;
    @GetMapping("/sayHello")
    public String sayHello(@RequestParam("name") String name) {
        log.info("controller request {}", name);
        new Thread(new MyTask()).start();
        new Thread(new MyTask()).start();
        new Thread(new MyTask()).start();
        return testService.sayHello(name);
    }
}


//@TraceCrossThread
@Slf4j
class MyTask implements Runnable {
    @Trace
    @Override
    public void run() {
        log.info("demo child task trackId {} local value {} test value {}", TraceContext.traceId(), TraceContext.getCorrelation("test").orElse("null"));
    }
}

