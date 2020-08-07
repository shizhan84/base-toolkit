package cn.okcoming.bean;

import io.swagger.annotations.ApiModelProperty;



/**
 * @author: bluces.wang
 *
 */
public class ResponseResult<T> extends BaseResult {
    @ApiModelProperty(value = "返回数据")
    private T data;

    public ResponseResult<T> success(T data) {
        this.setData(data);
        return this;
    }

    public ResponseResult<T> result(Integer code, String msg, T data) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
