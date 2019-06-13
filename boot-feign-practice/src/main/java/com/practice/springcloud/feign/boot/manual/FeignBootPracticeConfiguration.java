package com.practice.springcloud.feign.boot.manual;

import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.util.Assert;

/**
 * @author Luo Bao Ding
 * @since 2019/5/23
 */
@Configuration
@EnableAutoConfiguration
@EnableFeignClients
@Profile("manual")
public class FeignBootPracticeConfiguration {

    @Configuration
    @EnableConfigurationProperties(FeignBootPracticeProperties.class)
    @Import(FeignClientsConfiguration.class)
    static class ManualConfiguration {
        @Bean
        public ManualHttpbinClient manualHttpbinClient(Decoder decoder, Encoder encoder, Client client, Contract contract,
                                                       FeignBootPracticeProperties properties) {
            String url = properties.getUrl();
            Assert.hasText(url, "url should not be blank");
            return Feign.builder().client(client)
                    .decoder(decoder)
                    .encoder(encoder)
                    .contract(contract)
                    .target(ManualHttpbinClient.class, url);
        }
    }


}
