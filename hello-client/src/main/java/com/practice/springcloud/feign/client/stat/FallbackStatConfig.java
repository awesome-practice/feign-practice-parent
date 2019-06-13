package com.practice.springcloud.feign.client.stat;

import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisher;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesStrategy;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Luo Bao Ding
 * @since 2018/10/18
 */
@Configuration
public class FallbackStatConfig implements ApplicationRunner {

    @Bean
    public FallbackEventNotifier fallbackEventNotifier() {
        return new FallbackEventNotifier();
    }


    /**
     * 指定使用FallbackEventNotifier, 会覆盖原来的, 对框架或第三方metric包的功能可能有影响<p>
     * refer to: {@link io.micrometer.core.instrument.binder.hystrix.HystrixMetricsBinder#bindTo(io.micrometer.core.instrument.MeterRegistry)}
     */
    private void registerEventNotifier() {
        // Keeps references of existing Hystrix plugins.
        HystrixPropertiesStrategy propertiesStrategy = HystrixPlugins.getInstance().getPropertiesStrategy();
        HystrixCommandExecutionHook commandExecutionHook = HystrixPlugins.getInstance().getCommandExecutionHook();
        HystrixConcurrencyStrategy concurrencyStrategy = HystrixPlugins.getInstance().getConcurrencyStrategy();
        HystrixMetricsPublisher metricsPublisher = HystrixPlugins.getInstance().getMetricsPublisher();

        HystrixPlugins.reset();

        HystrixPlugins.getInstance().registerMetricsPublisher(metricsPublisher);
        HystrixPlugins.getInstance().registerConcurrencyStrategy(concurrencyStrategy);
        HystrixPlugins.getInstance().registerPropertiesStrategy(propertiesStrategy);
        HystrixPlugins.getInstance().registerCommandExecutionHook(commandExecutionHook);

        // set the custom notifier
        HystrixPlugins.getInstance().registerEventNotifier(fallbackEventNotifier());


    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        registerEventNotifier();
    }
}
