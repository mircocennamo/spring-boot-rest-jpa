package com.avanade.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author mirco.cennamo on 03/04/2025
 * @project spring-boot-rest-jpa
 */
@FeignClient(name = "ping-service")
public interface PingService {
    @GetMapping("/api/ping")
    String getPingResponse();
}