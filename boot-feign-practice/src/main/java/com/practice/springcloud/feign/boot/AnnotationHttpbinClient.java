package com.practice.springcloud.feign.boot;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "AnnotationHttpbinClient", url = "${app.feign.httpbin.url:http://httpbin.org}")
public interface AnnotationHttpbinClient {

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    Object get();

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    String msgRead(@RequestParam(value = "fid") Long fid, @RequestParam(value = "uid") Long uid,
                   @RequestParam(value = "msgTime") Integer msgTime);

}