package com.practice.springcloud.feign.client.hello;

import org.springframework.stereotype.Component;

/**
 * @author Luo Bao Ding
 * @since 2018/8/29
 */
@Component
public class HelloFeignClientFallback implements  HelloFeignClient {
    @Override
    public String greeting() {
        return "fallback";
    }

}
