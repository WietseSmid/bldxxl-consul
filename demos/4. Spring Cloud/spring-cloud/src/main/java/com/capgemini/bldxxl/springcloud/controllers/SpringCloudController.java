package com.capgemini.bldxxl.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
public class SpringCloudController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${consul-value}")
    private String consulValue;

    @RequestMapping("/")
    public String helloWorld() {
        return "Hello World from Spring cloud";
    }

    @RequestMapping("/services")
    public String services() {
        List<String> services = discoveryClient.getServices();
        return discoveryClient.getInstances(services.get(1)).get(0).getHost();
    }

    @RequestMapping("/consulvalue")
    public String consulValue() {
        return consulValue;
    }
}
