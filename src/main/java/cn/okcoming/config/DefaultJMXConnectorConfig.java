package cn.okcoming.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.support.ConnectorServerFactoryBean;

/**
 * 通过jmxmp协议访问mbean
 * 方便穿透防火墙
 * 用随机端口号 方便部署
 *
 * @author bluces
 */
@Configuration
public class DefaultJMXConnectorConfig {

    @Bean
    public ConnectorServerFactoryBean connectorServerFactoryBean(){
        ConnectorServerFactoryBean factoryBean = new ConnectorServerFactoryBean();
        factoryBean.setServiceUrl("service:jmx:jmxmp://localhost:0");
        return factoryBean;
    }

}
