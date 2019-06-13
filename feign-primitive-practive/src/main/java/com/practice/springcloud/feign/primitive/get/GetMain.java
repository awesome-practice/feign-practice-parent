package com.practice.springcloud.feign.primitive.get;

import feign.Feign;

import java.util.HashMap;

/**
 * @author Luo Bao Ding
 * @since 2019/5/23
 */
public class GetMain {

    public static void main(String[] args) {
        GetClient target = Feign.builder()
                .target(GetClient.class, "http://httpbin.org");

        HashMap<String, String> map = new HashMap<>(4);
        map.put("username", "john");
        map.put("age", "17");
        System.out.println("map = " + map);
        String result = target.simpleGet(map);
        System.out.println("result = " + result);

    }

}
