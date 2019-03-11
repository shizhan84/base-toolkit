package cn.okcoming.baseconfig;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 自定义定时任务执行线程池
 *
 * @EnableScheduling
 * @Configuration
 * @author bluces on 2017/11/17.
 */

public abstract class AbstractSchedulingConfigurer implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean
    public Executor taskExecutor() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().
                setNameFormat("schedule-pool-%d").build();
        return Executors.newScheduledThreadPool(2*Runtime.getRuntime().availableProcessors(),threadFactory);
    }
}
