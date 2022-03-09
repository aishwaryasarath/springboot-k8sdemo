package com.demogit.demogithubk8sj8.ws;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class demoController {
    @GetMapping("/hello")
    public String hello() { return "Hello - demo-k8s";}
}

