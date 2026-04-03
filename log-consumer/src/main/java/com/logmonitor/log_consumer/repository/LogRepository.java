package com.logmonitor.log_consumer.repository;

import com.logmonitor.log_consumer.model.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<LogEntity, Long> {
    List<LogEntity> findByLevel(String level);
    List<LogEntity> findByService(String service);
    long countByLevel(String level);
}