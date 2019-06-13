package com.practice.springcloud.feign.boot;

import com.practice.springcloud.feign.boot.manual.FeignBootPracticeConfiguration;
import com.practice.springcloud.feign.boot.manual.ManualHttpbinClient;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Luo Bao Ding
 * @since 2019/5/23
 */
public class HttpbinMain {

    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(FeignBootPracticeConfiguration.class, args);
        ConfigurableApplicationContext context = new SpringApplicationBuilder().sources(FeignBootPracticeConfiguration.class).build(args).run();
        AnnotationHttpbinClient client = context.getBean(AnnotationHttpbinClient.class);
        Object result = client.get();
        System.out.println("result = " + result);

        System.out.println("==============");
        ManualHttpbinClient manualHttpbinClient = context.getBean(ManualHttpbinClient.class);
        System.out.println(manualHttpbinClient.get());

    }
}
