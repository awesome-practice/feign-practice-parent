package com.practice.springcloud.feign.client.retry.byinterface;

import com.practice.springcloud.feign.client.retry.RetryFeignClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Luo Bao Ding
 * @since 2018/8/29
 */
@Component
public class RetryFeignClientFallbackFactory2 implements FallbackFactory<RetryFeignClient> {
    @Override
    public RetryFeignClient create(Throwable cause) {
        return new RetryFeignClientFallback2(cause);
    }
}
