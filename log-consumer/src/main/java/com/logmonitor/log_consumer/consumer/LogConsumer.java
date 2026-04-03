package com.logmonitor.log_consumer.consumer;

import com.logmonitor.log_consumer.model.LogEntity;
import com.logmonitor.log_consumer.model.LogMessage;
import com.logmonitor.log_consumer.repository.LogRepository;
import com.logmonitor.log_consumer.service.LogAiAnalyzer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LogConsumer {

    private  final LogRepository repository;
    private  final LogAiAnalyzer analyzer;
    public  LogConsumer(LogRepository repository,LogAiAnalyzer analyzer)
    {
        this.repository =repository;
        this.analyzer = analyzer;
    }

    @KafkaListener(topics = "logs-topic", groupId = "log-group")
    public  void  consume(LogMessage log)
    {
        LogEntity entity = new LogEntity();
        entity.setService(log.getService());
        entity.setLevel(log.getLevel());
        entity.setMessage(log.getMessage());

        if (log.getLevel().equalsIgnoreCase("ERROR")) {
            String analysis = analyzer.analyze(log.getMessage());
            entity.setAnalysis(analysis);  // ← save it
            System.out.println("AI Analysis:");
            System.out.println(analysis);
        }

        repository.save(entity);
        if (log.getLevel().equalsIgnoreCase("ERROR")) {

            String analysis = analyzer.analyze(log.getMessage());

            System.out.println("AI Analysis:");
            System.out.println(analysis);
        }
    }
}
