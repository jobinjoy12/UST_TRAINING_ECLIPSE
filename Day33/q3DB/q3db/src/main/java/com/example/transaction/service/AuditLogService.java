package com.example.transaction.service;

import com.example.transaction.entity.AuditLog;
import com.example.transaction.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuditLogService{

    private final AuditLogRepository auditLogRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void logAction(String message) {
        AuditLog auditLog = new AuditLog();
        auditLog.setTimestamp(LocalDateTime.now());
        auditLog.setMessage(message);
        auditLogRepository.save(auditLog);
    }
}