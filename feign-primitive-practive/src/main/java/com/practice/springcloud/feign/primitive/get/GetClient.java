package com.practice.springcloud.feign.primitive.get;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

/**
 * @author Luo Bao Ding
 * @since 2019/5/23
 */
public interface GetClient {


    @RequestLine("GET /get")
    @Headers("Accept: application/json")
    String simpleGet(@QueryMap Map<String, String> map);


}
