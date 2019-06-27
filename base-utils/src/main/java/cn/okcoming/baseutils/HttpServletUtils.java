package cn.okcoming.baseutils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.context.ContextLoader;

import javax.servlet.http.HttpServletRequest;

/**
 * 通过servlet容器提供的服务模块
 *
 */
@Slf4j
public class HttpServletUtils extends ApplicationObjectSupport {
    private static final String IP_UNKNOWN = "unknown";

    /**
     *  获取客户端ip
     * @param request
     * @return
     */
    public static String clientIP(HttpServletRequest request){

        String ip = request.getHeader("x-forwarded-for");
        if (ip != null && ip.length() != 0 && !IP_UNKNOWN.equalsIgnoreCase(ip)) {
            if( ip.indexOf(",")!=-1 ){
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 根据传入的类型获取spring管理的对应bean
     * @param clazz 类型
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return ContextLoader.getCurrentWebApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name,Class<T> clazz) {
        return ContextLoader.getCurrentWebApplicationContext().getBean(name,clazz);
    }
}
