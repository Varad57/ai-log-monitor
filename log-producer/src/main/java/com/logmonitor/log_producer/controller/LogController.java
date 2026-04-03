package com.logmonitor.log_producer.controller;


import com.logmonitor.log_producer.mode.LogMessage;
import com.logmonitor.log_producer.producer.LogProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
public class LogController {
    @Autowired
    private LogProducer producer;

    @PostMapping
    public String sendLog(@RequestBody LogMessage log)
    {
        producer.sendLog(log);
        return  "Log sent to Kafka";
    }
}
