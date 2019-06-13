package com.practice.springcloud.feign.boot.transmission;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luo Bao Ding
 * @since 2019/6/1
 */
@ConfigurationProperties("ufoto.app.transmission")
public class TransmissionProperties {

    private List<String> headers = new ArrayList<>();

    public List<String> getHeaders() {
        return headers;
    }

}
