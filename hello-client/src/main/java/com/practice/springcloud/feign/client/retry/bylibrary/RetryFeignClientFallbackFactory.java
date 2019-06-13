package com.practice.springcloud.feign.client.retry.bylibrary;

import com.practice.springcloud.feign.client.retry.RetryFeignClient;
import com.ufoto.infrastructrue.statistics.AbstractFallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Luo Bao Ding
 * @since 2018/8/29
 */
@Component
public class RetryFeignClientFallbackFactory extends AbstractFallbackFactory<RetryFeignClient> {

    private final RetryFeignClientFallback fallback;

    public RetryFeignClientFallbackFactory(RetryFeignClientFallback fallback) {
        this.fallback = fallback;
    }

    @Override
    protected RetryFeignClient doCreate() {
        return fallback;
    }


}
