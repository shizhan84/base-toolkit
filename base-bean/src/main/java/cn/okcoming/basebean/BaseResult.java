package cn.okcoming.basebean;

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
    private Integer code ;
    @ApiModelProperty(value = "返回提示信息")
    private String msg ;
    @ApiModelProperty(value = "返回成功失败状态")
    private Boolean success = true;

}
