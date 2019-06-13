package com.practice.springcloud.feign.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class FeignClientApplication {

    public static void main(String[] args) {
//        HystrixPlugins.getInstance().registerEventNotifier(new FallbackEventNotifier());

        SpringApplication.run(FeignClientApplication.class, args);
    }
}
