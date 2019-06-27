package cn.comming.masterslave;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

//@Aspect
public abstract class AbstractDataSourceContextAdvice {
 
    private final String[] QUERY_PREFIX = {"find","read","get","count"};

    public abstract void daoAspect();
 
    @Before("daoAspect()")
    public void switchDataSource(JoinPoint point) {
        Boolean isQueryMethod = isQueryMethod(point.getSignature().getName());
        if (isQueryMethod) {
            DataSourceContextHolder.setDataSourceType(DataSourceType.SLAVE);
        } else {
            DataSourceContextHolder.setDataSourceType(DataSourceType.MASTER);
        }
    }
 
    private Boolean isQueryMethod(String methodName) {
        for (String prefix : QUERY_PREFIX) {
            if (methodName.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

}
