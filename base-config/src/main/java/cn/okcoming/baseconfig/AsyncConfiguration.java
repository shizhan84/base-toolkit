package cn.okcoming.baseconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 使用子线程来处理并发任务
 * 只需要在需要异步处理的类方法上添加注解 @Async
 *
 * * @author bluces on 2017/11/9.
 */
@Configuration
public class AsyncConfiguration {

    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors());
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("asyncExecutor-");
        executor.initialize();
        return executor;
    }
}
