package com.microservices.carserver;

import com.netflix.discovery.EurekaNamespace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CarServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarServerApplication.class, args);
    }

}
