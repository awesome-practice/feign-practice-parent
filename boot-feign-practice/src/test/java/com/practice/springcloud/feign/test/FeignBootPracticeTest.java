package com.practice.springcloud.feign.test;

import com.practice.springcloud.feign.boot.AnnotationHttpbinClient;
import com.practice.springcloud.feign.boot.hierarchy.HierarchyAnnotationFeignClient;
import com.practice.springcloud.feign.boot.manual.FeignBootPracticeConfiguration;
import com.practice.springcloud.feign.boot.manual.ManualHttpbinClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Luo Bao Ding
 * @since 2019/5/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration
public class FeignBootPracticeTest {

    @Autowired
    private AnnotationHttpbinClient annotationHttpbinClient;

    @Autowired
    private ManualHttpbinClient manualHttpbinClient;


    @Autowired
    private HierarchyAnnotationFeignClient hierarchyAnnotationFeignClient;

    @Configuration
    @Import(FeignBootPracticeConfiguration.class)
    static class AppTestConfiguration {

    }

    @Test
    public void testAnnotationGet() {
        Object result = annotationHttpbinClient.get();
        System.out.println("result = " + result);

    }

    @Test
    public void testManualGet() {
        Object result = manualHttpbinClient.get();
        System.out.println("result = " + result);

    }

    @Test
    public void testHierarchy() {
        Object result = hierarchyAnnotationFeignClient.status();
        System.out.println("result = " + result);
    }


}
