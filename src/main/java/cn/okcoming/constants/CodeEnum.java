package cn.okcoming.constants;

/***
 * 
 */
public enum CodeEnum {

    OK(10000, "SUCCESS"),

    /**
     * 客户端错误
     */
    PARAM_ERROR(-1001, "参数异常"),
    ILLEGAL_ACCESS(-1002, "非法请求"),

    /*******************比较通用的业务错误-2开头******************/
    CODE_OFTEN(-2001, "获取验证码次数过多"),
    CODE_FAIL(-2002, "验证码过期，请重新获取"),
    CODE_ERROR(-2003, "验证码有误，请重新输入"),

    USER_TOKEN_EXPIRATION(-2005, "登录已失效，请重新登录"),
    USER_EXIST(-2006, "用户已存在"),
    USER_NOT_EXIST(-2008, "用户不存在"),
    USER_NO_PASSWORD(-2009, "用户未设置密码"),
    USER_PASSWORD_ERROR(-2010, "密码错误"),

    DATA_NOT_FOUND(-2011, "数据不存在"),
    DATA_ALREADY_EXIST(-2012, "数据已经存在"),

    /*******************系统错误-5开头******************/
    SERVER_ERROR(-5000, "系统异常，请稍后再试"),
    SERVER_TIMEOUT(-5001, "系统处理超时"),
    SERVER_DB_ERROR(-5007, "数据库操作错误"),

    THIRDPARTY_SYSTEM_ERROR(-5010, "第三方服务异常，请联系管理员！");


    private int code;
    private String msg;

    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}


