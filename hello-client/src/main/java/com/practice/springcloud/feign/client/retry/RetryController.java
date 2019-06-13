package com.practice.springcloud.feign.client.retry;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Luo Bao Ding
 * @since 2018/8/29
 */
@RestController
public class RetryController {

    private final RetryFeignClient retryFeignClient;

    public RetryController(RetryFeignClient retryFeignClient) {
        this.retryFeignClient = retryFeignClient;
    }


    @RequestMapping("/retry")
    public String retry() {
        return retryFeignClient.retry();
    }

    @RequestMapping("/sleep/{timeInSeconds}")
    public String sleep(@PathVariable("timeInSeconds") int timeInSeconds) {
        return retryFeignClient.sleep(timeInSeconds);
    }


}
