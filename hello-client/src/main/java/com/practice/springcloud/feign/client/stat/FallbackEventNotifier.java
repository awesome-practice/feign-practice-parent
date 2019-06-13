package com.practice.springcloud.feign.client.stat;

import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixEventType;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Luo Bao Ding
 * @since 2018/10/18
 */
public class FallbackEventNotifier extends HystrixEventNotifier {
    private static final Logger LOGGER = LoggerFactory.getLogger(FallbackEventNotifier.class);

    public void markEvent(HystrixEventType eventType, HystrixCommandKey key) {
        switch (eventType) {
            case FAILURE:
            case TIMEOUT:
            case SHORT_CIRCUITED:
            case SEMAPHORE_REJECTED:
            case THREAD_POOL_REJECTED:
                LOGGER.warn("**********{} {}", key.name(), eventType);
        }


        // do nothing
    }


}
