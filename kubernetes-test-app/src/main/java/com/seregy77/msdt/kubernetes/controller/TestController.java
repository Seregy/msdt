package com.seregy77.msdt.kubernetes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping
    public String index() {
        return "Kubernetes test app";
    }
}
