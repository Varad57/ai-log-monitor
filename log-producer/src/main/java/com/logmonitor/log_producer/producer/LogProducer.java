package com.logmonitor.log_producer.producer;

import com.logmonitor.log_producer.mode.LogMessage;
//import jakarta.websocket.server.ServerEndpoint;
//import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LogProducer {

    @Autowired
    private KafkaTemplate<String, LogMessage> kafkaTemplate;

    private  static  final String TOPIC = "logs-topic";

    public  void sendLog(LogMessage log)
    {
        kafkaTemplate.send(TOPIC,log);
    }
}
