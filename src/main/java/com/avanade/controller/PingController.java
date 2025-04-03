package com.avanade.controller;

import com.avanade.service.PingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mirco.cennamo on 03/04/2025
 * @project spring-boot-rest-jpa
 */
@RestController
@RequestMapping("avanade")
public class PingController {

    @Autowired
    private PingService pingService;


    @GetMapping("/ping")
    public String ping() {
        return pingService.getPingResponse();
    }


}
