package com.qa.lmsproject.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyAuditListener { 
    private static final Logger LOG = LoggerFactory.getLogger("security");

    @EventListener
    public void onAuditEvent(AuditApplicationEvent event) {
        AuditEvent auditEvent = event.getAuditEvent();
        LOG.info("typeprincipal={}", auditEvent.getType(), auditEvent.getPrincipal(), auditEvent.getData());
        System.out.println(auditEvent.getData());
    }
}