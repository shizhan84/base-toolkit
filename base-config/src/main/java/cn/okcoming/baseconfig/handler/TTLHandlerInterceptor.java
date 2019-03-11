package cn.okcoming.baseconfig.handler;

import cn.okcoming.basejmx.mbean.TTLMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.management.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/**
 * 按请求url分组记录响应时间
 *
 * 通过mbean以jmx方式对外暴露
 * @author bluces
 */
public class TTLHandlerInterceptor implements HandlerInterceptor{

    private static final ConcurrentMap<String, TTLMonitor> urls = new ConcurrentHashMap<>();

    @Autowired(required = false)
    private MBeanServer server;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        request.setAttribute("TTLBeginTime",System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if(server == null){
            return;
        }
        String url = request.getRequestURI();
        //要持续优化掉不需要的非业务请求url的监控
        if(url.length() > 60 || url.length() < 3){
            return;
        }else if(url.contains("/webjars/") || url.contains("/swagger-") || url.contains("/actuator")){
            return;
        }else{
            //去掉第一个通用路径
            url = url.substring(url.indexOf("/",2)).replace("/","_");
        }
        Long ttlBeginTime = (Long) request.getAttribute("TTLBeginTime");
        TTLMonitor ttlMonitor = urls.get(url);
        if(ttlMonitor == null){
            ttlMonitor = new TTLMonitor();
            TTLMonitor ret = urls.putIfAbsent(url,ttlMonitor);
            if(ret == null){//放进去的和取出来的是同一个
                //MBeanServer server = ManagementFactory.getPlatformMBeanServer();
                ObjectName mxbeanName = new ObjectName("cn.okcoming.request:type=TTL,name="+url);
                ttlMonitor.setObjectName(mxbeanName);
                server.registerMBean(ttlMonitor, mxbeanName);
            }else{
                ttlMonitor = ret;
            }
        }
        ttlMonitor.compute(System.currentTimeMillis()- ttlBeginTime);
    }

}
