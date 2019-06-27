package cn.comming.masterslave;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
 
       if(DataSourceContextHolder.getDataSourceType() == DataSourceType.SLAVE){
            return DataSourceType.SLAVE;
        }
 
        return DataSourceType.MASTER;
    }
}
