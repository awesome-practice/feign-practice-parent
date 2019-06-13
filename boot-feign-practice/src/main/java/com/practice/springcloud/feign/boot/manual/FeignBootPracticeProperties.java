package com.practice.springcloud.feign.boot.manual;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Luo Bao Ding
 * @since 2019/5/23
 */
@ConfigurationProperties("app.feign.httpbin")
public class FeignBootPracticeProperties {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
