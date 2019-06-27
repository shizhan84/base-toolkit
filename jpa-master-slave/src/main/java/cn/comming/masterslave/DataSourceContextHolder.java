package cn.comming.masterslave;

public class DataSourceContextHolder {
    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<>();
 
    public static void setDataSourceType(DataSourceType dataSourceType) {
        if(dataSourceType == null){
            throw new NullPointerException();
        }
        contextHolder.set(dataSourceType);
    }
 
    public static DataSourceType getDataSourceType() {
        return contextHolder.get();
    }
 
    public static void clearDataSourceType() {
        contextHolder.remove();
    }
}
