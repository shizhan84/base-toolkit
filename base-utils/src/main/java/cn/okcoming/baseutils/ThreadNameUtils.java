package cn.okcoming.baseutils;

import java.util.Objects;
import java.util.function.Function;

/**
 * 一些线程相关的可以共用的方法
 *
 * @author bluces
 */
public class ThreadNameUtils {


    /**自定义线程池中线程名称 方便在日志追踪问题*/
    public static Runnable proxyRunnable(final Thread parentThread, Runnable action){
        return () -> {
            String threadName = Thread.currentThread().getName();
            try{
                Thread.currentThread().setName(threadName +"-"+parentThread.getName());
                action.run();
            }finally {
                Thread.currentThread().setName(threadName);
            }
        };
    }

    /**自定义线程池中线程名称 方便在日志追踪问题*/
    public static <T,R> R proxyFunction(Thread parentThread, T name , Function<T,R> fun) {
        String poolThreadName = Thread.currentThread().getName();
        if (!Objects.equals(parentThread.getName(), poolThreadName)) {//forkjoin的第一个任务线程就是主线程
            Thread.currentThread().setName(poolThreadName + "-" + parentThread.getName());
        }
        R result = fun.apply(name);
        Thread.currentThread().setName(poolThreadName);
        return result;
    }

}
