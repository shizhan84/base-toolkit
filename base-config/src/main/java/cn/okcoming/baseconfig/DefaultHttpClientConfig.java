package cn.okcoming.baseconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * 创建带请求耗时日志的resttemplate实例
 *
 */
@Slf4j
@Configuration
public class DefaultHttpClientConfig {

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.getInterceptors().add(new TraceHttpRequestInterceptor());
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(10000);//等待响应时间
        factory.setConnectTimeout(3000);//连接超时时间
        return factory;
    }

    class TraceHttpRequestInterceptor implements ClientHttpRequestInterceptor {
        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            long beginTime = System.currentTimeMillis();
            ClientHttpResponse response = execution.execute(request, body);
            log.info("request consuming time {} ms => {}",System.currentTimeMillis()-beginTime,request.getURI());
            return response;
        }
    }
}
