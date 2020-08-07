package cn.okcoming.datasource.route;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DataSourceConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "master.datasource")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }
 
    @Bean
    @ConfigurationProperties(prefix = "slave.datasource")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }
 
    @Bean
    public DataSource routeDataSource() {
        return new RoutingDataSource() {{
            setDefaultTargetDataSource(masterDataSource());
            setTargetDataSources(new HashMap<Object, Object>() {{
                put(DataSourceType.MASTER, masterDataSource());
                put(DataSourceType.SLAVE, slaveDataSource());
            }});
        }};
    }
 
    @Bean
    @Primary
    public LazyConnectionDataSourceProxy lazyConnectionDataSourceProxy() {
        return new LazyConnectionDataSourceProxy(routeDataSource());
    }
}