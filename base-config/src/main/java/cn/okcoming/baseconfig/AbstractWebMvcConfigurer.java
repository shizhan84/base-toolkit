package cn.okcoming.baseconfig;

import cn.okcoming.baseconfig.handler.AllowCrossDomainInterceptor;
import cn.okcoming.baseconfig.handler.TTLHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/*
 *  一个webmvc configuration例子，
 *  业务模块可以继承该类来完成token的授权拦截器功能，也可以参考该类自己实现
 *
 * @author bluces
 */
public abstract class AbstractWebMvcConfigurer implements WebMvcConfigurer {



     /**
     * 拦截器必需通过类似这种注解方式来获取实例
     * 否则拦截器用到的参数无法注入
     * @return
     */
    /*@Bean
    @ConditionalOnClass(
            name = {"org.springframework.data.redis.core.RedisTemplate"}
    )
    public UserManagerInterceptor userManagerInterceptor(){
        return new UserManagerInterceptor();
    }*/

    @Bean
    public TTLHandlerInterceptor ttlHandlerInterceptor() {
        return new TTLHandlerInterceptor();
    }

    @Bean
    public AllowCrossDomainInterceptor allowCrossDomainInterceptor() {
        return new AllowCrossDomainInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //默认开启ttl记录
        registry.addInterceptor(ttlHandlerInterceptor());

        //跨域设置
        registry.addInterceptor(allowCrossDomainInterceptor());

    }

}
