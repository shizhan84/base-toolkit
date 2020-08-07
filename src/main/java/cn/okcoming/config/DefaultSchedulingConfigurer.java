package cn.okcoming.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/**
 * 自定义定时任务执行线程池
 *
 * @author bluces on 2017/11/17.
 */

@EnableScheduling
@Configuration
public class DefaultSchedulingConfigurer implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean
    public ScheduledExecutorService taskExecutor() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().
                setNameFormat("schedule-pool-%d").build();
        return Executors.newScheduledThreadPool(2*Runtime.getRuntime().availableProcessors(),threadFactory);
    }
}
