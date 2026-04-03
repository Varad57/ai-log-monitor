package com.logmonitor.log_consumer.controller;

import com.logmonitor.log_consumer.model.LogEntity;
import com.logmonitor.log_consumer.repository.LogRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    private final LogRepository repository;

    public LogController(LogRepository repository) {
        this.repository = repository;
    }

    // Get all logs
    @GetMapping
    public List<LogEntity> getAllLogs() {
        return repository.findAll();
    }

    // Get logs by level
    @GetMapping("/level/{level}")
    public List<LogEntity> getByLevel(@PathVariable String level) {
        return repository.findByLevel(level);
    }

    // Get logs by service
    @GetMapping("/service/{service}")
    public List<LogEntity> getByService(@PathVariable String service) {
        return repository.findByService(service);
    }

    // Get statistics
    @GetMapping("/stats")
    public Map<String, Long> getStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("total", repository.count());
        stats.put("errors", repository.countByLevel("ERROR"));
        stats.put("warnings", repository.countByLevel("WARN"));
        stats.put("info", repository.countByLevel("INFO"));
        return stats;
    }
}