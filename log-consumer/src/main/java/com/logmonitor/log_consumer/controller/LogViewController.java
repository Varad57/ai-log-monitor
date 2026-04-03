package com.logmonitor.log_consumer.controller;

import com.logmonitor.log_consumer.repository.LogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Note: Use @Controller, NOT @RestController for HTML pages
public class LogViewController {

    private final LogRepository repository;

    public LogViewController(LogRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Send the list of logs and total count to the HTML template
        model.addAttribute("logs", repository.findAll());
        model.addAttribute("totalLogs", repository.count());
        model.addAttribute("errorCount", repository.countByLevel("ERROR"));
        return "dashboard"; // This maps to src/main/resources/templates/dashboard.html
    }
}