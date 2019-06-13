package com.practice.springcloud.feign.client.retry.bylibrary;

import com.practice.springcloud.feign.client.retry.RetryFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author Luo Bao Ding
 * @since 2018/10/18
 */
@Component
public class RetryFeignClientFallback implements RetryFeignClient {

    @Override
    public String retry() {
        return "fallback";

    }

    @Override
    public String sleep(int timeInSeconds) {
        return "fallback";
    }
}
