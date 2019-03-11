package cn.okcoming.basebean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author: bluces.wang
 *
 */
@Data
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

}
