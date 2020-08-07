package cn.okcoming.bean;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author: bluces.wang
 *
 */
public class BaseResult implements Serializable {

    @ApiModelProperty(value = "返回码")
    private Integer code ;
    @ApiModelProperty(value = "返回提示信息")
    private String msg ;
    @ApiModelProperty(value = "返回成功失败状态")
    private Boolean success = true;

    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", success=" + success +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
