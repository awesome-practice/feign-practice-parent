package com.practice.springcloud.feign.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Luo Bao Ding
 * @since 2019/6/1
 */
@SpringBootApplication
@EnableFeignClients
public class HttpbinFeignPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpbinFeignPracticeApplication.class, args);
    }
}
