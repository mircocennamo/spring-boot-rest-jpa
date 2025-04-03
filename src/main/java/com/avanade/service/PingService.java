package com.avanade.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mirco.cennamo on 03/04/2025
 * @project spring-boot-rest-jpa
 */
@FeignClient(name = "ping", url = "${ping.url}")
public interface PingService {
    @GetMapping("/api/ping")
    String getPingResponse();
}
