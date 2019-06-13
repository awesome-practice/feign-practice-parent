package com.practice.springcloud.feign.boot.transmission;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.List;

/**
 * @author Luo Bao Ding
 * @since 2019/6/1
 */
public class TransmissionValPutFeignRequestInterceptor implements RequestInterceptor {
    private final TransmissionProperties transmissionProperties;

    private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

    public TransmissionValPutFeignRequestInterceptor(TransmissionProperties transmissionProperties) {
        this.transmissionProperties = transmissionProperties;
    }


    @Override
    public void apply(RequestTemplate template) {
        List<String> headers = transmissionProperties.getHeaders();
        for (String header : headers) {
            String value = TransmissionContextHolder.getVal(header);
            template.header(header, value);
            if (logger.isTraceEnabled()) {
                logger.trace("put " + header + " to feign RequestTemplate: " + template);
            }
        }
        TransmissionContextHolder.clear();
        if (logger.isTraceEnabled()) {
            logger.trace("cleared thread-bound Transmission Context at feign RequestTemplate: " + template);
        }
    }
}
