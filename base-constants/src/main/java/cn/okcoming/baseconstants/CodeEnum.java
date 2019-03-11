package cn.okcoming.baseconstants;

/***
 * 
 */
public enum CodeEnum {

    OK(10000, "SUCCESS"),

    /**
     * 0
     *
     * 未查中
     *
     * 库中无此号
     *
     * 1
     *
     * 一致
     *
     * 姓名、身份证号匹配
     *
     * -1000
     *
     * 不一致
     *
     * 查询库中此条身份证号码对应的姓名和上传的不符
     *
     * -1001
     *
     * 必录项缺失,姓名不能为空
     *
     *
     *
     * -1002
     *
     * 必录项缺失,身份证号不能为空
     *
     *
     *
     * -1003
     *
     * 必录项缺失,银行卡号不能为空
     *
     *
     *
     * -1004
     *
     * 必录项缺失,手机号不能为空
     *
     *
     *
     * -1005
     *
     * 姓名格式不正确
     *
     *
     *
     * -1006
     *
     * 身份证号码格式不正确
     *
     *
     *
     * -1007
     *
     * 手机号格式不正确
     *
     *
     *
     * -1008
     *
     * 银行卡号码格式不正确
     *
     *
     *
     * -1009
     *
     * 库中无此号，请核实
     *
     *
     *
     * -1010
     *
     * 服务器内部错误
     *
     *
     *
     * -1011
     *
     * 服务器连接超时
     *
     *
     *
     * 其他编码
     *
     * 若为第三方调用，以返回为准
     */
    /**
     * 客户端错误
     */
    PARAM_ERROR(-1001, "参数异常"),
    ILLEGAL_ERROR(-1002, "非法请求"),


    /*******************系统错误-1开头******************/
    /**
     * 服务端系统异常
     */
    ERROR(-1000, "系统异常，请稍后再试"),
    CREATE_FAIL(-1007, "保存失败"),
    MODIFY_FAIL(-1008, "修改失败"),
    REMOVE_FAIL(-1009, "删除失败"),


    /*******************通用业务错误-2开头******************/

    CODE_OFTEN(-2001, "获取验证码次数过多，请一分钟后再试"),
    CODE_FAIL(-2002, "验证码过期，请重新获取"),
    CODE_ERROR(-2003, "验证码有误，请重新输入"),
    TOO_MUCH_MESSAGE(-2004, "数据加载过多，请在地图上缩小查询范围"),
    LOGIN_TOKEN_INVALID(-2005, "登录已失效，请重新登录"),
    IGNORE(-2006, "忽略，不需要处理"),

    INTERFACE_SYSTEM_ERROR(-2007, "外部接口调用异常，请联系管理员！"),

    NO_REGISTER(-2008, "用户尚未注册"),
    NO_PASSWORD(-2009, "用户尚未设置密码"),
    PASSWORD_ERROR(-2010, "密码错误"),
    TEL_EXIST(-2011, "用户已经注册"),
    CODE_EXPIRE(-2012, "取验证码过期，请重发送验证码或刷新页面重试"),

    /***********内部服务错误代码-3开头***************/
    BAIDU_ERROR(-3001, "调用百度地图失败"),
    POI_NOT_EXIST(-3002, "POI不存在"),

    /***********功能性提示2开头***************/
    NEWEST(2001, "已经是最新版本");


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

