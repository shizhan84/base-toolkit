package cn.okcoming.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author bluces
 */
@Configuration
@ConditionalOnWebApplication
public class DefaultDruidConfig {

    @Bean
    public ServletRegistrationBean statViewServlet(){
        /** 创建servlet注册实体 */
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        /** 设置ip白名单 */
        servletRegistrationBean.addInitParameter("allow","127.0.0.1,172.16.0.0/16,10.0.0.0/8");
        /** 设置ip黑名单，如果allow与deny共同存在时,deny优先于allow*/
        servletRegistrationBean.addInitParameter("deny","10.10.0.19");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter(){
        /** 创建过滤器 */
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        /** 设置过滤器过滤路径*/
        filterRegistrationBean.addUrlPatterns("/*");
        /** 忽略过滤的形式*/
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,druid/*");
        return filterRegistrationBean;
    }
}
