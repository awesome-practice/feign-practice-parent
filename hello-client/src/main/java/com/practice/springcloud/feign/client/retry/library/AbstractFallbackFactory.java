//package com.practice.springcloud.feign.client.retry.library;
//
//import feign.hystrix.FallbackFactory;
//import org.apache.commons.lang3.exception.ExceptionUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * @author Luo Bao Ding
// * @since 2018/10/19
// */
//public abstract class AbstractFallbackFactory<T> implements FallbackFactory<T> {
//    private static final Logger LOGGER = LoggerFactory.getLogger("LOGGER-CIRCUIT-BREAKER");
//
//    protected abstract T doCreate();
//
//    @Override
//    public T create(Throwable cause) {
//        logFallback(cause);
//        return doCreate();
//    }
//
//    private void logFallback(Throwable cause) {
//        String msg = ExceptionUtils.getMessage(cause);
//        String rootCauseMessage = ExceptionUtils.getRootCauseMessage(cause);
//        LOGGER.warn("{} Caused by: {}", msg, rootCauseMessage);
//    }
//}
