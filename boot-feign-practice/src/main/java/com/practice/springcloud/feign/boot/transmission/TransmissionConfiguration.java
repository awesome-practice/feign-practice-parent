package com.practice.springcloud.feign.boot.transmission;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Luo Bao Ding
 * @since 2019/6/1
 */
@Configuration
@EnableConfigurationProperties(TransmissionProperties.class)
public class TransmissionConfiguration {


    @Bean
    public TransmissionValPutFeignRequestInterceptor transmissionFeignRequestInterceptor(TransmissionProperties transmissionProperties) {
        return new TransmissionValPutFeignRequestInterceptor(transmissionProperties);
    }

    @Bean
    public TransmissionValExtractServletFilter transmissionValExtractServletFilter(TransmissionProperties transmissionProperties) {
        return new TransmissionValExtractServletFilter(transmissionProperties);
    }
}
