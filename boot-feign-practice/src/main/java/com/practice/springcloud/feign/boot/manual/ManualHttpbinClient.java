package com.practice.springcloud.feign.boot.manual;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Luo Bao Ding
 * @since 2019/5/23
 */
public interface ManualHttpbinClient {
    @RequestMapping(method = RequestMethod.GET, value = "/get")
    Object get();

}
