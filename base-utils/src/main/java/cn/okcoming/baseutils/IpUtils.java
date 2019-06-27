package cn.okcoming.baseutils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author 傅振锋
 * @date 2018/9/26 14:20
 */
@Slf4j
public class IpUtils {

    private static final String IP_UNKNOWN = "unknown";

    /**
     * 获取本机IP
     * @return
     */
    public static String getLocalIP(){
        String localIp = "127.0.0.1";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while(networkInterfaces.hasMoreElements()){
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                if(networkInterface.isLoopback() || networkInterface.isVirtual()){
                    continue;
                }
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while(inetAddresses.hasMoreElements()){
                    InetAddress inetAddress = inetAddresses.nextElement();
                    //ipv4的地址
                    if(inetAddress instanceof Inet4Address){
                        ip = inetAddress;
                        break;
                    }
                }
                if(ip != null){
                    break;
                }
            }
            if(ip != null){
                localIp = ip.getHostAddress();
            }
        } catch (SocketException e) {
            log.warn("{}",ExceptionUtils.exception2detail(e));
        }
        return localIp;
    }

}
