package com.practice.springcloud.feign.boot.hierarchy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Luo Bao Ding
 * @since 2019/5/23
 */
@Profile("hierarchy")
@FeignClient(name = "Hierarchy2AnnotationFeignClient", url = "http://httpbin.org")
@RequestMapping("/status")
public interface Hierarchy2AnnotationFeignClient {

    @RequestMapping("/200")
    Object status();
}
