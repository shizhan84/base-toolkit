package cn.okcoming.basebean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ListResult<T> extends BaseResult {

    @ApiModelProperty(value = "返回数据")
    private List<T> data;
}
