package cn.okcoming.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author bluces.wang  2017/11/17.
 */
public class ObjectMapperUtils {
    private static Logger log = LoggerFactory.getLogger(ObjectMapperUtils.class);

    /** 可以单例模式 线程安全 */
    private static final ObjectMapper mapper = new ObjectMapper();
    static {
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    /**
     * 把对象转换成json字符串
     * @param object
     * @return
     */
    public static String writeValueAsString(Object object){
        if(object == null){
            return null;
        }
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("{}",object);
            log.error("",e);
        }
        return null;
    }

    /**
     * 根据
     * @param jsonStr
     * @param valueType
     * @param <T>
     * @return
     */
    public static <T> T parseObject(String jsonStr,Class<T> valueType){
        if(jsonStr == null){
            return null;
        }
        try {
            return mapper.readValue(jsonStr,valueType);
        } catch (IOException e) {
            log.warn("解析JSON数据到对象[{}]出错: {}", valueType, jsonStr);
            log.error("",e);
        }
        return null;
    }

    /**
     * 用法
     *  ObjectMapperUtils.parseObject(jsonstr,new TypeReference<ResponseResult<UserDTO>>(){});
     * @param jsonStr
     * @param valueType
     * @param <T>
     * @return
     */
    public static <T> T parseObject(String jsonStr,TypeReference<T> valueType){
        if(jsonStr == null){
            return null;
        }
        try {
            return mapper.readValue(jsonStr,valueType);
        } catch (IOException e) {
            log.warn("解析JSON数据到对象[{}]出错: {}", valueType, jsonStr);
            log.error("",e);
        }
        return null;
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }
}
