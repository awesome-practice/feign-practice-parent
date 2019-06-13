package com.practice.springcloud.feign.client.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final HelloFeignClient helloFeignClient;

    public HelloController(HelloFeignClient helloFeignClient) {
        this.helloFeignClient = helloFeignClient;
    }

    @RequestMapping("/greeting")
    public String hello() {
        return helloFeignClient.greeting();
    }

}
