package cn.okcoming.baseutils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.TimeZone;

/***
 * 基于jdk8的新时间库提供的方法
 *
 * @author bluces.wang
 */
@Slf4j
public class DateUtils {

    /** 标准日期格式：yyyy-MM-dd */
    public final static DateTimeFormatter NORM_DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /** 标准时间格式：HH:mm:ss */
    public final static DateTimeFormatter NORM_TIME_PATTERN = DateTimeFormatter.ofPattern("HH:mm:ss");

    /** 标准日期时间格式，精确到秒：yyyy-MM-dd HH:mm:ss */
    public final static DateTimeFormatter NORM_DATETIME_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    /** 标准日期时间格式，精确到毫秒：yyyy-MM-dd HH:mm:ss.SSS */
    public final static DateTimeFormatter NORM_DATETIME_MS_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");


    /** 标准日期格式：yyyyMMdd */
    public final static DateTimeFormatter PURE_DATE_PATTERN = DateTimeFormatter.ofPattern("yyyyMMdd");


    /** HTTP头中日期时间格式：EEE, dd MMM yyyy HH:mm:ss z */
    public final static DateTimeFormatter HTTP_DATETIME_PATTERN = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z");


    /** JDK中日期时间格式：EEE MMM dd HH:mm:ss zzz yyyy */
    public final static String JDK_DATETIME_PATTERN = "EEE MMM dd HH:mm:ss zzz yyyy";


    /** UTC时间：yyyy-MM-dd'T'HH:mm:ss'Z' */
    public final static DateTimeFormatter UTC_PATTERN =  DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    /** UTC时间{@link FastDateFormat}：yyyy-MM-dd'T'HH:mm:ss'Z' */
    //public final static FastDateFormat UTC_FORMAT = FastDateFormat.getInstance(UTC_PATTERN, TimeZone.getTimeZone("UTC"));


    /**
     * 根据特定格式格式化日期
     *
     * @param date 被格式化的日期
     * @param format 日期格式
     * @return 格式化后的字符串
     */
    public static String format(Temporal date, String format) {
        if (null == date || StringUtils.isBlank(format)) {
            return null;
        }
        return format(date, DateTimeFormatter.ofPattern(format));
    }

    /**
     * 根据特定格式格式化日期
     *
     * @param date 被格式化的日期
     * @param format {@link FastDateFormat} 或 {@link FastDateFormat}
     * @return 格式化后的字符串
     */
    public static String format(Temporal date, DateTimeFormatter format) {
        if (null == format || null == date) {
            return null;
        }
        return format.format(date);
    }

    /**
     * 格式化为Http的标准日期格式
     *
     * @param date 被格式化的日期
     * @return HTTP标准形式日期字符串
     */
    public static String formatHttpDate(Temporal date) {
        if (null == date) {
            return null;
        }
        return  HTTP_DATETIME_PATTERN.format(date);
    }
    public static LocalDateTime parseHttpDate(String date) {
        if (null == date) {
            return null;
        }
        return LocalDateTime.parse(date,HTTP_DATETIME_PATTERN);
    }

    /**
     * 解析UTC时间，格式为：yyyy-MM-dd'T'HH:mm:ss'Z
     *
     * @param utcString UTC时间
     * @return 日期对象
     * @since 4.1.14
     */
    public static LocalDateTime parseUTC(String utcString) {
        if (StringUtils.isBlank(utcString)) {
            return null;
        }
        Instant instant = Instant.parse(utcString);
        return LocalDateTime.ofInstant(instant, TimeZone.getTimeZone("UTC").toZoneId());
    }

    public static Temporal parse(String dateStr,DateTimeFormatter pattern) {
        if (null == dateStr) {
            return null;
        }

        return LocalDateTime.parse(dateStr,pattern);
    }

    /**
     * 格式要求：<br>
     * 1、yyyy-MM-dd HH:mm:ss <br>
     * 2、yyyy-MM-dd <br>
     * 3、HH:mm:ss <br>
     * */
    public static Temporal parse(String dateStr) {
        if (null == dateStr) {
            return null;
        }

        dateStr = dateStr.trim();
        if(dateStr.length() == 19 ){
            return LocalDateTime.parse(dateStr,NORM_DATETIME_PATTERN);
        }else if(dateStr.length() == 10 ){
            return LocalDate.parse(dateStr,NORM_DATE_PATTERN);
        }else if(dateStr.length() == 8 ){
            return LocalTime.parse(dateStr,NORM_TIME_PATTERN);
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        LocalDate  localDateTime = (LocalDate) parse("2018-01-01");
    }

}
