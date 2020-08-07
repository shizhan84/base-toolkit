package cn.okcoming.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.instrument.async.LazyTraceExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 使用子线程来处理并发任务
 * 只需要在异步处理的类方法上添加注解 @Async
 *
 * 使用LazyTraceExecutor 确保traceId和spanId正确的传递
 * @author bluces on 2019/11/9.
 */
@Configuration
@EnableAsync
public class DefaultAsyncTraceConfig extends AsyncConfigurerSupport {
    @Autowired
    private BeanFactory beanFactory;

    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors());
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("asyncExecutor-");
        executor.initialize();
        return new LazyTraceExecutor(beanFactory,executor);
    }
}
