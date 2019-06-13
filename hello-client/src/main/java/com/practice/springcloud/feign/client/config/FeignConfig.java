//package com.practice.springcloud.feign.client.config;
//
//import feign.Retryer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FeignConfig {
//
//    //会与ribbon的retry累乘
//    @Bean
//    Retryer feignRetryer() {
//        return new Retryer.Default(1000, 100, 3);
//    }
//}
