package com.practice.springcloud.feign.client.retry;

import com.practice.springcloud.feign.client.retry.bylibrary.RetryFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Luo Bao Ding
 * @since 2018/8/29
 */
@FeignClient(name = "ribbon-practice-server-say-hello", fallbackFactory = RetryFeignClientFallbackFactory.class)
public interface RetryFeignClient {

    @RequestMapping("/retry")
    String retry();

    @RequestMapping("/sleep/{timeInSeconds}")
    String sleep(@PathVariable("timeInSeconds") int timeInSeconds);


}
