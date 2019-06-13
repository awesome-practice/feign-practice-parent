package com.practice.springcloud.feign.client.retry.byinterface;

import com.practice.springcloud.feign.client.retry.RetryFeignClient;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Luo Bao Ding
 * @since 2018/10/18
 */
public class RetryFeignClientFallback2 implements RetryFeignClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(RetryFeignClientFallback2.class);

    private Throwable cause;

    public RetryFeignClientFallback2(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public String retry() {
        log();
        return "retry fallback; Caused by: " + cause.getClass().getName() + ": " + cause.getMessage();
    }

    @Override
    public String sleep(int timeInSeconds) {
        log();
        return "sleep fallback; Caused by: " + ExceptionUtils.getMessage(cause);
    }

    private void log() {
        LOGGER.error("{}; Caused by: {}", ExceptionUtils.getMessage(cause), ExceptionUtils.getRootCauseMessage(cause));
    }
}
