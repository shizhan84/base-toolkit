package cn.okcoming.baseutils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

/***
 * 需要基于新版的时间库提供一套方法
 *
 * TODO @author bluces.wang
 */
@Slf4j
public class DateUtils {
    public final static String WEB_DATE_TIME_FORMAT2 = "yyyy-MM-dd'T'HH:mm:ss";
    public final static String WEB_DATE_TIME_ZONE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";
    public final static String WEB_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String WEB_DATE = "yyyy/MM/dd";
    public final static String NEW_WEB_DATE = "yyyy-MM-dd";
    public final static String NEW_WEB_DATE2 = "yyyyMMdd";

    /**
     * yyyy-MM-dd'T'HH:mm:ss
     */
    public static Date parseDateTime2(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(str, WEB_DATE_TIME_FORMAT2);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * yyyy-MM-dd'T'HH:mm:ssZ
     */
    public static Date parseDateTimeZone(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(str, WEB_DATE_TIME_ZONE_FORMAT);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static Date parseDateTime(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(str, WEB_DATE_TIME_FORMAT);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static Date parseDateNoTime(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(str, NEW_WEB_DATE2);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * yyyy/MM/dd
     */
    public static Date parseWebDate(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(str, WEB_DATE);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * yyyy/MM/dd
     */
    public static Date parseNewWebDate(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(str, NEW_WEB_DATE);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * yyyy/MM/dd
     */
    public static String getNewWebDate(Date date) {
        if (date == null) {
            return "";
        }
        return DateFormatUtils.format(date, NEW_WEB_DATE);
    }

}
