package cn.okcoming.basebean;

import cn.okcoming.baseconstants.CodeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: bluces.wang
 *
 */
@Data
public class BaseResult implements Serializable {

    @ApiModelProperty(value = "返回码")
    private Integer code = CodeEnum.OK.getCode();
    @ApiModelProperty(value = "返回提示信息")
    private String msg = CodeEnum.OK.getMsg();
    @ApiModelProperty(value = "返回成功失败状态")
    private Boolean success = true;

    public <T> T error(CodeEnum errorEnum) {
        this.setCode(errorEnum.getCode());
        this.setMsg(errorEnum.getMsg());
        this.setSuccess(false);
        return (T)this;
    }
}
