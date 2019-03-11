package cn.okcoming.baseutils;

import java.math.BigDecimal;

/**
 * 一些可以共用的方法集合
 *
 * @author bluces
 */
public class MethodUtils {

    /**
     * 将分为单位的转换为元 （除100）
     *
     * @param amount
     * @return
     * @throws Exception
     */
    public static String changeF2Y(Long amount){
        if(amount == null){
            return null;
        }
        return BigDecimal.valueOf(amount).divide(new BigDecimal(100)).toString();
    }

    /**
     * 将元为单位的转换为分 （乘100）
     *
     * @param amount
     * @return
     */
    public static Long changeY2F(BigDecimal amount){
        if(amount == null){
            return null;
        }
        return amount.multiply(new BigDecimal(100)).longValue();
    }

    /**
     * 将元为单位的转换为分 替换小数点，支持以逗号区分的金额
     * @param amount
     * @return
     */
    public static Long changeY2F(String amount){
        if(amount == null){
            return null;
        }
        String currency =  amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额
        int index = currency.indexOf(".");
        int length = currency.length();
        Long amLong = 0l;
        if(index == -1){
            amLong = Long.valueOf(currency+"00");
        }else if(length - index >= 3){
            amLong = Long.valueOf((currency.substring(0, index+3)).replace(".", ""));
        }else if(length - index == 2){
            amLong = Long.valueOf((currency.substring(0, index+2)).replace(".", "")+0);
        }else{
            amLong = Long.valueOf((currency.substring(0, index+1)).replace(".", "")+"00");
        }
        return amLong;
    }
}
