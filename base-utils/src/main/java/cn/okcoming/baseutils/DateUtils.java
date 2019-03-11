package cn.okcoming.baseutils;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/***
 * 需要基于新版的时间库提供一套方法
 *
 * @author bluces.wang
 */
@Slf4j
public class DateUtils {
    private static final DateTimeFormatter DTF1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DTF2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static LocalDateTime parseDateTime(String str) {
        return LocalDateTime.parse(str, DTF1);
    }
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static String formatDateTime(LocalDateTime date) {
        return date.format(DTF1);
    }
    /**
     * yyyy-MM-dd
     */
    public static LocalDate parseDate(String str) {
        return LocalDate.parse(str,DTF2);
    }

    /**
     * yyyy-MM-dd
     */
    public static String formatDate(LocalDate date) {
        return date.format(DTF2);
    }

    public static void main(String[] args) {
        System.out.println(formatDate(LocalDate.now()));
        System.out.println(formatDateTime(LocalDateTime.now()));
        System.out.println(parseDate("2019-03-11"));
        System.out.println(parseDateTime("2019-03-11 00:01:02"));
    }

}
