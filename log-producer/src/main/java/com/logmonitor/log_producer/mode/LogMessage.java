package com.logmonitor.log_producer.mode;

import lombok.Data;

@Data
public class LogMessage {

    private String service;
    private String level;
    private String message;
}