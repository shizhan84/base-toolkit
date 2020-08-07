package cn.okcoming.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 默认的访问路径授权
 * 只针对接口文档和druid监控的路径授权访问
 * @author bluces
 */
@EnableWebSecurity
@Configuration
public class DefaultWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/swagger-ui.html","/druid/*","/v2/api-docs").authenticated()
                .anyRequest().permitAll().and().httpBasic();
    }
}