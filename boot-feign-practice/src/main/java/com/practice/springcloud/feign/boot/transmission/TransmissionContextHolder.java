package com.practice.springcloud.feign.boot.transmission;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Luo Bao Ding
 * @since 2019/6/1
 */
final class TransmissionContextHolder {
    private static final ThreadLocal<Map<String, String>> currentTransmissionContext = ThreadLocal.withInitial(LinkedHashMap::new);

    static void putKV(String key, String value) {
        currentTransmissionContext.get().put(key, value);
    }

    static String getVal(String key) {
        return currentTransmissionContext.get().get(key);
    }

    static void clear() {
        currentTransmissionContext.remove();
    }

}
