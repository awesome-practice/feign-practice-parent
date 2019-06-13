package com.practice.springcloud.feign.client.hello;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "ribbon-practice-server-say-hello", fallback = HelloFeignClientFallback.class)
public interface HelloFeignClient {

    @RequestMapping("/greeting")
    String greeting();



}
