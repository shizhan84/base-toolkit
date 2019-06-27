package cn.okcoming.basejmx;

import cn.okcoming.basejmx.mbean.TTLMonitor;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MBeanUtils {
    private static final ConcurrentMap<String, TTLMonitor> TTL_MAP = new ConcurrentHashMap<>();

    /**
     * 计算请求响应的时间 并把mbean注册到mbeanServer上
     * @param url
     * @param ttl
     */
    public static void computeTTL(String url,long ttl){
        MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();
        if(mbeanServer == null){
            return;
        }

        TTLMonitor ttlMonitor = TTL_MAP.get(url);
        if(ttlMonitor == null){
            ttlMonitor = new TTLMonitor();
            TTLMonitor ret = TTL_MAP.putIfAbsent(url,ttlMonitor);
            if(ret == null){//放进去的和取出来的是同一个
                try {
                    mbeanServer.registerMBean(ttlMonitor, new ObjectName("cn.okcoming.api:type=TTL,name="+url));
                } catch (InstanceAlreadyExistsException e) {
                    e.printStackTrace();
                } catch (MBeanRegistrationException e) {
                    e.printStackTrace();
                } catch (NotCompliantMBeanException e) {
                    e.printStackTrace();
                } catch (MalformedObjectNameException e) {
                    e.printStackTrace();
                }
            }else{
                ttlMonitor = ret;
            }
        }
        ttlMonitor.compute(ttl);
    }
}
